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

    // Home page
    @GetMapping("/")
    public String showHomePage(Model model) {
        model.addAttribute("appointment", new Appointment());
        return "index";
    }

    // Test JSP
    @GetMapping("/hello")
    public String testJsp() {
        return "hello";
    }

    // Show the standalone booking form (book_appointment.jsp)
    @GetMapping("/book_appointment")
    public String showBookAppointmentForm(Model model) {
        model.addAttribute("appointment", new Appointment());
        return "book_appointment";  // resolves to /WEB-INF/views/book_appointment.jsp
    }

    // Handle the form submission
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
        // Redirect back to the booking page with success flag
        return "redirect:/book_appointment?success=true";
    }

    // View all appointments (appointments.jsp)
    @GetMapping("/appointments")
    public String viewAppointments(
            Model model,
            @RequestParam(required = false) String success
    ) {
        model.addAttribute("appointments", service.getAll());
        model.addAttribute("success", success != null);
        return "appointments";  // resolves to /WEB-INF/views/appointments.jsp
    }

    // Static pages
    @GetMapping("/contact")
    public String showContactPage() {
        return "contact";
    }

    @GetMapping("/about")
    public String showAboutPage() {
        return "about";
    }

    @GetMapping("/service")
    public String showService() {
        return "service";
    }

    @GetMapping("/testimonial")
    public String showTestimonial() {
        return "testimonial";
    }

    @GetMapping("/team")
    public String showTeamPage() {
        return "team";
    }

    @GetMapping("/price")
    public String showPricingPage() {
        return "price";
    }
}
