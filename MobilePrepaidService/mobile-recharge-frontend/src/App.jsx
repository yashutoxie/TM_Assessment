import React, { useState, useEffect } from "react";
import { BrowserRouter as Router, Routes, Route, Navigate } from "react-router-dom"; // Add Navigate for redirection
import Home from "./pages/Home";
import Recharge from "./pages/Recharge"; // Import Recharge page
import Profile from "./pages/Profile";
import LoginForm from "./components/LoginForm";
import RegistrationForm from "./components/RegistrationForm";

export default function App() {
  const [user, setUser] = useState(null);

  useEffect(() => {
    // Check if there's a stored user in localStorage when the app loads
    const storedUser = JSON.parse(localStorage.getItem("user"));
    if (storedUser) {
      setUser(storedUser); // Set the user state if found
    }
  }, []);

  return (
    <Router>
      <Routes>
        {/* Home Page */}
        <Route path="/" element={<Home />} />

        {/* Recharge Page */}
        <Route
          path="/recharge"
          element={user ? <Recharge user={user} setUser={setUser} /> : <Navigate to="/login" />} // Pass user and setUser to Recharge
        />

        {/* Profile Page */}
        <Route
          path="/profile"
          element={user ? <Profile user={user} setUser={setUser} /> : <Navigate to="/login" />}
        />

        {/* Login Page */}
        <Route
          path="/login"
          element={
            user ? (
              <Navigate to="/recharge" /> // Redirect to recharge if already logged in
            ) : (
              <LoginForm
                onLoginSuccess={(user) => {
                  localStorage.setItem("user", JSON.stringify(user)); // Store user in localStorage
                  setUser(user); // Update user state
                }}
              />
            )
          }
        />

        {/* Signup Page */}
        <Route path="/signup" element={<RegistrationForm />} />
      </Routes>
    </Router>
  );
}