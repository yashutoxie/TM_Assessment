import React, { useState } from "react";
import "./RegistrationForm.css";

const RegistrationForm = () => {
  const [username, setUsername] = useState("");
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [message, setMessage] = useState(""); // To show success or error messages

  const handleSubmit = async (event) => {
    event.preventDefault();
    setMessage(""); // Clear previous messages

    const formData = { username, email, password };

    try {
      const response = await fetch("http://localhost:8080/api/users/register", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(formData),
      });

      if (response.ok) {
        setMessage("Registration successful! 🎉");
      } else {
        const errorData = await response.json();
        setMessage(errorData.error || "Registration failed. Try again.");
      }
    } catch (error) {
      setMessage("Could not connect to the server.");
    }
  };

  return (
    <div className="registration-form-container">
      <h2>Register</h2>
      {message && <p className="message">{message}</p>} {/* Show success or error message */}
      <form onSubmit={handleSubmit} className="registration-form">
        <div className="form-field">
          <label>Username</label>
          <input
            type="text"
            value={username}
            onChange={(e) => setUsername(e.target.value)}
            required
          />
        </div>
        <div className="form-field">
          <label>Email</label>
          <input
            type="email"
            value={email}
            onChange={(e) => setEmail(e.target.value)}
            required
          />
        </div>
        <div className="form-field">
          <label>Password</label>
          <input
            type="password"
            value={password}
            onChange={(e) => setPassword(e.target.value)}
            required
          />
        </div>
        <button type="submit" className="submit-btn">Register</button>
      </form>
    </div>
  );
};

export default RegistrationForm;