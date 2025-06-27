package com.subrat.clinic.controller;

import com.subrat.clinic.model.Appointment;
import com.subrat.clinic.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Controller
public class AppointmentController {

    @Autowired
    private AppointmentService service;

    @GetMapping("/")
    public String showHomePage(Model model) {
        model.addAttribute("appointment", new Appointment());
        return "index";
 
    }
    //Tested Pupose 
    @GetMapping("/hello")
    public String testJsp() 
    {
        return "hello";
    }
    
    @PostMapping("/book")
    public String bookAppointment(
            @RequestParam String patientName,
            @RequestParam String email,
            @RequestParam String phone,
            @RequestParam String doctorName,
            @RequestParam("service") String serviceType,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate appointmentDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.TIME) LocalTime appointmentTime
    ) {
        Appointment appointment = new Appointment();
        appointment.setPatientName(patientName);
        appointment.setEmail(email);
        appointment.setPhone(phone);
        appointment.setDoctorName(doctorName);
        appointment.setService(serviceType);
        appointment.setAppointmentDate(appointmentDate);
        appointment.setAppointmentTime(appointmentTime);

        service.save(appointment);
        return "appointments";
    }



    @GetMapping("/appointments")
    public String viewAppointments(Model model) {
        model.addAttribute("appointments", service.getAll());
        return "appointments"; // resolves to /WEB-INF/views/appointments.jsp
    }
    
    @GetMapping("/contact")
    public String showContactPage() {
        return "contact"; // maps to contact.jsp
    }
    
    @GetMapping("/about")
    public String showAboutPage() {
        return "about"; // maps to about.jsp
    }
    @GetMapping("/service")
    public String showService() {
        return "service";
    }
    @GetMapping("/testimonial")
    public String showTestimonial() {
        return "testimonial"; // maps to testimonials.jsp
    }
    
    @GetMapping("/team")
    public String showTeamPage() {
        return "team"; // maps to team.jsp
    }
    
    @GetMapping("/price")
    public String showPricingPage() {
        return "price"; // maps to pricing.jsp
    }




}
