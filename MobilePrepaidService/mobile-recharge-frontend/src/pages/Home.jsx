import React from "react";
import { useNavigate } from "react-router-dom";
import "./home.css"; // Make sure this file is correctly linked

const Home = () => {
  const navigate = useNavigate();

  return (
    <div className="home-container">
      {/* White Box with Rounded Edges */}
      <div className="white-box">
        {/* Top Right Corner Navigation Buttons */}
        <div className="top-buttons">
          <button className="nav-button" onClick={() => navigate("/")}>Home</button>
          <button className="nav-button" onClick={() => navigate("/recharge")}>Recharge</button>
          <button className="nav-button" onClick={() => navigate("/profile")}>Profile</button>
        </div>

        {/* Welcome Text */}
        <h1 className="welcome">WELCOME</h1>
        <h2 className="to">TO</h2>
        <h1 className="mobile-recharge">MOBILE RECHARGE SYSTEM</h1>

        {/* Login & Signup Buttons */}
        <div className="login-signup">
          <button className="login-button" onClick={() => navigate("/login")}>Login</button>
          <button className="signup-button" onClick={() => navigate("/signup")}>Signup</button>
        </div>
      </div>
    </div>
  );
};

export default Home;