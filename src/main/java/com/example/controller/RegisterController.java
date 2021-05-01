package com.example.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.data.UserRepository;
import com.example.security.RegistrationForm;
@Controller
@RestController
@RequestMapping(path="/register", produces="application/json")
public class RegisterController {
	private UserRepository userRepo;
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	public RegisterController(
			UserRepository userRepo, PasswordEncoder passwordEncoder) {
		this.userRepo = userRepo;
		this.passwordEncoder = passwordEncoder;
	}
	@GetMapping
	public String registerForm() {
		return "register";
	}
	@PostMapping
	public String processRegistration(RegistrationForm form) {
		userRepo.save(form.toUser(passwordEncoder));
		return "redirect:/login";
	}
}