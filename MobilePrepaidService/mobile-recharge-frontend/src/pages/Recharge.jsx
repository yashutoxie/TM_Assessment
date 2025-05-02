import React, { useState, useEffect } from "react";
import { 
  Container, Box, TextField, Button, Typography, MenuItem, 
  Select, InputLabel, FormControl, Alert 
} from "@mui/material";
import axios from "axios";
import { useNavigate } from "react-router-dom";

const Recharge = ({ user, setUser }) => {
  const [phoneNumber, setPhoneNumber] = useState("");
  const [plan, setPlan] = useState("");
  const [amount, setAmount] = useState("");
  const [successMessage, setSuccessMessage] = useState("");
  const [errorMessage, setErrorMessage] = useState("");
  const [mobilePlans, setMobilePlans] = useState([]);  
  const navigate = useNavigate();

  useEffect(() => {
    const fetchPlans = async () => {
      try {
        const response = await axios.get("/api/recharge-plans");
        setMobilePlans(response.data);
      } catch (error) {
        console.error("Error fetching recharge plans:", error);
        setErrorMessage("Failed to fetch recharge plans.");
      }
    };

    fetchPlans();

    // Retrieve user info from localStorage
    const storedUser = JSON.parse(localStorage.getItem("user"));
    if (!storedUser || !storedUser.id) {
      navigate("/login");
    } else {
      setUser(storedUser); // Set user state
    }
  }, [navigate, setUser]);

  const handleRecharge = async () => {
    setSuccessMessage("");
    setErrorMessage("");

    if (!phoneNumber || !plan || !amount) {
      setErrorMessage("All fields are required.");
      return;
    }

    if (isNaN(amount) || parseFloat(amount) <= 0) {
      setErrorMessage("Please enter a valid recharge amount.");
      return;
    }

    try {
      const response = await axios.post("/api/recharge", {
        phoneNumber,
        plan,
        amount,
        userId: user.id,  // Ensure user.id is correctly passed here
      });

      if (response.status === 200) {
        setSuccessMessage("Recharge successful! 🎉");
        const updatedUser = { ...user, balance: user.balance + parseFloat(amount) };
        setUser(updatedUser);
        localStorage.setItem("user", JSON.stringify(updatedUser));
      }
    } catch (error) {
      console.error("Recharge error:", error);
      setErrorMessage("Recharge failed. Please try again.");
    }
  };

  return (
    <Container maxWidth="sm">
      <Box
        sx={{
          backgroundColor: "#ffcccc", // Light red background
          padding: "20px",
          borderRadius: "8px",
          boxShadow: "0 4px 10px rgba(0,0,0,0.1)",
          marginTop: "20px",
        }}
      >
        <Box
          sx={{
            backgroundColor: "#ffffff", // White background for the form
            padding: "20px",
            borderRadius: "8px",
            boxShadow: "0 4px 10px rgba(0,0,0,0.1)",
          }}
        >
          <Typography variant="h4" align="center" gutterBottom>
            Recharge Your Mobile
          </Typography>
          {successMessage && <Alert severity="success">{successMessage}</Alert>}
          {errorMessage && <Alert severity="error">{errorMessage}</Alert>}
          <form onSubmit={(e) => e.preventDefault()}>
            <TextField
              label="Phone Number"
              fullWidth
              value={phoneNumber}
              onChange={(e) => setPhoneNumber(e.target.value)}
              margin="normal"
              required
            />
            <FormControl fullWidth margin="normal" required>
              <InputLabel>Mobile Plan</InputLabel>
              <Select
                value={plan}
                onChange={(e) => setPlan(e.target.value)}
                label="Mobile Plan"
              >
                {mobilePlans.length > 0 ? (
                  mobilePlans.map((plan, index) => (
                    <MenuItem key={index} value={plan.name}>
                      {plan.name} - ${plan.price} - {plan.operator} ({plan.validity} days)
                    </MenuItem>
                  ))
                ) : (
                  <MenuItem disabled>No plans available</MenuItem>
                )}
              </Select>
            </FormControl>
            <TextField
              label="Recharge Amount"
              type="number"
              fullWidth
              value={amount}
              onChange={(e) => setAmount(e.target.value)}
              margin="normal"
              required
            />
            <Button
              variant="contained"
              color="primary"
              fullWidth
              onClick={handleRecharge}
              sx={{ marginTop: "20px" }}
            >
              Recharge
            </Button>
          </form>
        </Box>
      </Box>
    </Container>
  );
};

export default Recharge;