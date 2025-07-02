package com.subrat.clinic.controller;

import com.subrat.clinic.model.Doctor;
import com.subrat.clinic.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class DoctorController {

    @Autowired
    private DoctorService service;

    @GetMapping("/doctors")
    public String viewDoctors(Model model) {
        model.addAttribute("doctors", service.getAll());
        return "doctors";
    }

    @GetMapping("/doctors/add")
    public String showAddForm(Model model) {
        model.addAttribute("doctor", new Doctor());
        return "add_doctor";
    }

    @PostMapping("/doctors/save")
    public String saveDoctor(@ModelAttribute Doctor doctor) {
        service.save(doctor);
        return "redirect:/doctors";
    }

    @GetMapping("/doctors/edit/{id}")
    public String editDoctor(@PathVariable Long id, Model model) {
        model.addAttribute("doctor", service.getById(id));
        return "add_doctor";
    }

    @GetMapping("/doctors/delete/{id}")
    public String deleteDoctor(@PathVariable Long id) {
        service.deleteById(id);
        return "redirect:/doctors";
    }
}
