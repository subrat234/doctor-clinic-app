package com.subrat.clinic.service;

import com.subrat.clinic.model.Appointment;
import java.util.List;

public interface AppointmentService {
    Appointment save(Appointment appointment);
    List<Appointment> getAll();
}
