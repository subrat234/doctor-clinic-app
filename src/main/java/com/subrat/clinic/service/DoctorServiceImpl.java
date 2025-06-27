package com.subrat.clinic.service;

import com.subrat.clinic.model.Doctor;
import com.subrat.clinic.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    private DoctorRepository repo;

    @Override
    public List<Doctor> getAllDoctors() {
        return repo.findAll();
    }
}
