package com.example.ap3_partie2_roles.controllers;

import com.example.ap3_partie2_roles.entities.Patient;
import com.example.ap3_partie2_roles.repositories.PatientRepository;
import com.example.ap3_partie2_roles.services.IHospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public class PatientRestController {
    @Autowired
    private PatientRepository patientRepository;


    @GetMapping("/patients")
    public List<Patient> patientList(){
        return patientRepository.findAll();
    }
}
