package com.subrat.clinic.controller;

import com.subrat.clinic.model.Patient;
import com.subrat.clinic.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AuthenticationController {

    @Autowired
    private PatientService patientService;

    // Show the registration form
    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        model.addAttribute("patient", new Patient());
        return "register";
    }

    // Process registration
    @PostMapping("/register")
    public String registerUser(
            @ModelAttribute Patient patient,
            @RequestParam String confirmPassword,
            Model model
    ) {
        if (!patient.getPassword().equals(confirmPassword)) {
            model.addAttribute("error", "Passwords do not match.");
            return "register";
        }
        // Save the patient (you may want to hash the password)
        patientService.save(patient);
        return "redirect:/login";
    }

    // Show the login form
    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }

    // Process login
    @PostMapping("/login")
    public String loginUser(
            @RequestParam String email,
            @RequestParam String password,
            Model model
    ) {
        // Lookup patient by email (you need a findByEmail in PatientRepository)
        Patient existing = patientService.findByEmail(email);
        if (existing == null || !existing.getPassword().equals(password)) {
            model.addAttribute("error", "Invalid email or password.");
            return "login";
        }
        // On success, you can store user in session if needed
        return "redirect:/";
    }
}
