package com.subrat.clinic.controller;

import com.subrat.clinic.model.Doctor;
import com.subrat.clinic.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin/doctors")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @GetMapping
    public String listDoctors(Model model) {
        List<Doctor> doctors = doctorService.findAll();
        model.addAttribute("doctors", doctors);
        return "doctor_list"; // doctor_list.jsp
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("doctor", new Doctor());
        return "doctor_form"; // doctor_form.jsp
    }

    @PostMapping("/save")
    public String saveDoctor(@ModelAttribute Doctor doctor) {
        doctorService.save(doctor);
        return "redirect:/admin/doctors";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Doctor doctor = doctorService.findById(id);
        model.addAttribute("doctor", doctor);
        return "doctor_form";
    }

    @GetMapping("/delete/{id}")
    public String deleteDoctor(@PathVariable Long id) {
        doctorService.deleteById(id);
        return "redirect:/admin/doctors";
    }
}
