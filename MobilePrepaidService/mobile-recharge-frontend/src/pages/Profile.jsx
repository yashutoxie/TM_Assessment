import React, { useState, useEffect } from "react";
import { useNavigate } from "react-router-dom";
import axios from "axios";
import { Container, TextField, Button, Typography, Box, Alert } from "@mui/material";

export default function Profile({ user, setUser }) {
  const [profile, setProfile] = useState(user || {});
  const [message, setMessage] = useState(""); // To show success or error messages
  const navigate = useNavigate();

  useEffect(() => {
    const storedUser = JSON.parse(localStorage.getItem("user"));
    if (!storedUser) {
      navigate("/login"); // Redirect to login if not logged in
      return;
    }

    // Fetch the user profile from the backend
    axios
      .get(`http://localhost:8080/api/users/${storedUser.id}`)
      .then((response) => setProfile(response.data))
      .catch((error) => console.error("Error fetching profile:", error));
  }, [navigate]);

  const handleChange = (e) => {
    setProfile({ ...profile, [e.target.name]: e.target.value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    setMessage(""); // Clear previous messages

    try {
      // Update profile on the backend
      await axios.put(`http://localhost:8080/api/users/${profile.id}`, profile);
      setMessage("Profile updated successfully! 🎉");
      setUser(profile); // Update user state after successful update
      localStorage.setItem("user", JSON.stringify(profile)); // Sync with localStorage
    } catch (error) {
      setMessage("Failed to update profile. Please try again.");
    }
  };

  const handleLogout = () => {
    localStorage.removeItem("user");
    setUser(null); // Reset user state
    navigate("/login"); // Redirect to login page
  };

  return (
    <Container maxWidth="sm">
      <Box
        sx={{
          backgroundColor: "white", // White background for the form container
          padding: "20px",
          borderRadius: "8px",
          boxShadow: "0 4px 10px rgba(0,0,0,0.1)",
          marginTop: "20px",
        }}
      >
        <Typography variant="h4" align="center" gutterBottom>
          Profile Management
        </Typography>
        {message && <Alert severity="success" sx={{ marginBottom: "20px" }}>{message}</Alert>} {/* Success or error message */}
        <form onSubmit={handleSubmit}>
          <TextField
            fullWidth
            label="Username"
            name="username"
            value={profile.username || ""}
            onChange={handleChange}
            margin="normal"
            required
          />
          <TextField
            fullWidth
            label="Email"
            name="email"
            value={profile.email || ""}
            onChange={handleChange}
            margin="normal"
            required
          />
          <TextField
            fullWidth
            label="New Password"
            name="password"
            type="password"
            value={profile.password || ""}
            onChange={handleChange}
            margin="normal"
          />
          <Button type="submit" variant="contained" color="primary" fullWidth sx={{ marginTop: "20px" }}>
            Update Profile
          </Button>
          <Button
            variant="outlined"
            color="secondary"
            fullWidth
            onClick={handleLogout}
            sx={{ marginTop: "10px" }}
          >
            Logout
          </Button>
        </form>
      </Box>
    </Container>
  );
}