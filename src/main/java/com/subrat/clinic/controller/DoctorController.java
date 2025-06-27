package com.subrat.clinic.controller;

import com.subrat.clinic.model.Doctor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class DoctorController {

    @GetMapping("/doctors")
    public String showDoctors(Model model) {
        List<Doctor> sampleDoctors = List.of(
            new Doctor("Dr. Arya Mehta", "Orthodontist", "https://cdn.pixabay.com/photo/2017/08/06/00/15/people-2587313_1280.jpg", "Specializes in braces and smile alignment."),
            new Doctor("Dr. Rahul Das", "Periodontist", "https://i.imgur.com/def456.jpg", "Expert in gum care and dental implants."),
            new Doctor("Dr. Anita Rao", "Pediatric Dentist", "https://images.unsplash.com/photo-1588776814546-ec7e5f1b4f6e", "Loves caring for kids' dental health.")
        );
        model.addAttribute("doctors", sampleDoctors);
        return "doctors"; // maps to doctors.jsp
    }
}
