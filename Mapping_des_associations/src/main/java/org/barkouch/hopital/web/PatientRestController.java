package org.barkouch.hopital.web;

import org.barkouch.hopital.entity.Patient;
import org.barkouch.hopital.repos.PatientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PatientRestController {
    @Autowired
    PatientRepo patientRepo;

    @GetMapping("/patients")
    public List<Patient> patientList(){
        return patientRepo.findAll();
    }
}
