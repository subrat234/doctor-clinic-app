package com.subrat.clinic.controller;

import com.subrat.clinic.model.Patient;
import com.subrat.clinic.model.Doctor;
import com.subrat.clinic.service.PatientService;
import com.subrat.clinic.service.DoctorService;

import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AuthenticationController {

    @Autowired
    private PatientService patientService;

    @Autowired
    private DoctorService doctorService;

    // Show the registration form for user
    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        model.addAttribute("patient", new Patient());
        return "register";
    }

    // Process user registration
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
        patientService.save(patient);
        return "redirect:/login";
    }

    // Show shared login form
    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }

    // ✅ UPDATED: Unified login logic for both user and doctor
    @PostMapping("/login")
    public String loginUserOrDoctor(
            @RequestParam String email,
            @RequestParam String password,
            @RequestParam String role,
            HttpSession session,
            Model model
    ) {
        if ("user".equals(role)) {
            Patient existing = patientService.findByEmail(email);
            if (existing == null || !existing.getPassword().equals(password)) {
                model.addAttribute("error", "Invalid email or password.");
                return "login";
            }
            session.setAttribute("user", existing);
            return "redirect:/user/dashboard";
        } else if ("admin".equals(role)) {
            Doctor existing = doctorService.findByEmail(email);
            if (existing == null || !existing.getPassword().equals(password)) {
                model.addAttribute("error", "Invalid email or password.");
                return "login";
            }
            session.setAttribute("doctor", existing);
            return "redirect:/doctor/dashboard";
        }

        model.addAttribute("error", "Invalid role selected.");
        return "login";
    }

    // Optional: Logout
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }
}
