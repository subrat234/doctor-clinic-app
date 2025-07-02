package com.subrat.clinic.service.impl;

import com.subrat.clinic.model.Doctor;
import com.subrat.clinic.repository.DoctorRepository;
import com.subrat.clinic.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    private DoctorRepository repository;

    @Override
    public Doctor save(Doctor doctor) {
        return repository.save(doctor);
    }

    @Override
    public List<Doctor> getAll() {
        return repository.findAll();
    }

    @Override
    public Doctor getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
