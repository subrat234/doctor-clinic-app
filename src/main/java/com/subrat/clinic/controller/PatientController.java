package com.subrat.clinic.controller;

import com.subrat.clinic.model.Patient;
import com.subrat.clinic.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PatientController {

    @Autowired
    private PatientService service;

    @GetMapping("/patients")
    public String viewPatients(Model model) {
        model.addAttribute("patients", service.getAll());
        return "patients";
    }

    @GetMapping("/patients/add")
    public String showAddForm(Model model) {
        model.addAttribute("patient", new Patient());
        return "add_patient";
    }

    @PostMapping("/patients/save")
    public String savePatient(@ModelAttribute Patient patient) {
        service.save(patient);
        return "redirect:/patients";
    }

    @GetMapping("/patients/edit/{id}")
    public String editPatient(@PathVariable Long id, Model model) {
        model.addAttribute("patient", service.getById(id));
        return "add_patient";
    }

    @GetMapping("/patients/delete/{id}")
    public String deletePatient(@PathVariable Long id) {
        service.deleteById(id);
        return "redirect:/patients";
    }
}
