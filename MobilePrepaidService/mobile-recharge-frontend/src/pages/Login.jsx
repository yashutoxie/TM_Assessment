import React, { useState } from "react";
import { TextField, Button, Container, Box, Typography, Alert } from "@mui/material";
import { useNavigate } from "react-router-dom";

const Login = ({ onLoginSuccess }) => {
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");
  const [error, setError] = useState("");
  const [success, setSuccess] = useState(false);
  const navigate = useNavigate();

  const handleLogin = async (e) => {
    e.preventDefault();
    setError("");
    setSuccess(false);

    try {
      const response = await fetch("http://localhost:8080/api/auth/user-login", {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify({ username, password }),
      });

      const data = await response.json();

      if (response.ok && data.success) {
        localStorage.setItem("user", JSON.stringify(data.user));
        onLoginSuccess(data.user);
        setSuccess(true);
        navigate("/recharge");
      } else {
        setError(data.message || "Invalid username or password");
      }
    } catch (err) {
      console.error("Login failed:", err);
      setError("An error occurred. Please try again.");
    }
  };

  return (
    <Container
      maxWidth="xs"
      sx={{
        display: "flex",
        justifyContent: "center",
        alignItems: "center",
        height: "100vh",
      }}
    >
      <Box
        sx={{
          backgroundColor: "white",
          padding: "40px",
          borderRadius: "10px",
          boxShadow: "0px 0px 10px rgba(0, 0, 0, 0.1)",
          textAlign: "center",
          width: "100%",
        }}
      >
        <Typography variant="h4" fontWeight="bold" gutterBottom>
          Login
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
            <Alert severity="error" sx={{ marginTop: "10px" }}>
              {error}
            </Alert>
          )}
          {success && (
            <Alert severity="success" sx={{ marginTop: "10px" }}>
              Login Successful!
            </Alert>
          )}

          <Button
            fullWidth
            variant="contained"
            color="primary"
            sx={{ marginTop: "20px", backgroundColor: "#008cba", fontSize: "16px" }}
            type="submit"
          >
            Login
          </Button>
        </form>
      </Box>
    </Container>
  );
};

export default Login;
