package com.subrat.clinic.service;

import com.subrat.clinic.model.Doctor;
import java.util.List;

public interface DoctorService {
    Doctor save(Doctor doctor);
    List<Doctor> getAll();
    Doctor getById(Long id);
    void deleteById(Long id);
}
