import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import { TextField, Button, Container, Typography, Box, Alert } from "@mui/material";
import axios from "axios";

const LoginForm = ({ onLoginSuccess }) => {
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");
  const [error, setError] = useState("");
  const [success, setSuccess] = useState(false); // For success message
  const navigate = useNavigate();

  const handleLogin = async (e) => {
    e.preventDefault();
    setError("");
    setSuccess(false); // Reset success state

    try {
      const response = await axios.post("http://localhost:8080/api/auth/user-login", {
        username,
        password,
      });

      if (response.data.success && response.data.user) {
        localStorage.setItem("user", JSON.stringify(response.data.user));
        onLoginSuccess(response.data.user);
        setSuccess(true);
        navigate("/profile");
      } else {
        setError(response.data.message || "Invalid username or password");
      }
    } catch (error) {
      console.error("Login error:", error);
      setError("Login failed. Please try again.");
    }
  };

  return (
    <Container maxWidth="sm">
      <Box
        sx={{
          backgroundColor: "white", // Set white background for form
          padding: "20px",
          borderRadius: "8px",
          boxShadow: "0 4px 10px rgba(0,0,0,0.1)",
          marginTop: "20px",
        }}
      >
        <Typography variant="h4" align="center" gutterBottom>
          User Login
        </Typography>
        <form onSubmit={handleLogin}>
          <TextField
            fullWidth
            label="Username"
            variant="outlined"
            margin="normal"
            value={username}
            onChange={(e) => setUsername(e.target.value)}
            required
          />
          <TextField
            fullWidth
            label="Password"
            type="password"
            variant="outlined"
            margin="normal"
            value={password}
            onChange={(e) => setPassword(e.target.value)}
            required
          />
          {error && (
            <Alert severity="error" sx={{ marginBottom: "10px" }}>
              {error}
            </Alert>
          )}
          {success && (
            <Alert severity="success" sx={{ marginBottom: "10px" }}>
              Login Successful! 🎉
            </Alert>
          )}
          <Button type="submit" variant="contained" color="primary" fullWidth>
            Login
          </Button>
        </form>
      </Box>
    </Container>
  );
};

export default LoginForm;