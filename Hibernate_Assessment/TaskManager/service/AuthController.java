package com.springboot.TaskManager.service;

import com.springboot.TaskManager.User;
import com.springboot.TaskManager.repository.UserRepo;
import com.springboot.jwt.AuthRequest;
import com.springboot.jwt.AuthResponse;
import com.springboot.jwt.JwtUtil;

import jakarta.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.*;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

	@Autowired
	private AuthenticationConfiguration authenticationConfiguration;

	private AuthenticationManager authenticationManager;

	@PostConstruct
	public void init() throws Exception {
		this.authenticationManager = authenticationConfiguration.getAuthenticationManager();
	}

	@Autowired
	private CustomUserDetailsService userDetailsService;

	@Autowired
	private JwtUtil jwtUtil;

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@PostMapping("/register")
	public String register(@RequestBody User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		userRepo.save(user);
		return "User registered successfully!";
	}

	@PostMapping("/login")
	public AuthResponse login(@RequestBody AuthRequest request) {
		authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));

		UserDetails userDetails = userDetailsService.loadUserByUsername(request.getUsername());
		String token = jwtUtil.generateToken(userDetails.getUsername());
		System.out.println("Login success");
		return new AuthResponse(token);
	}
}
