package org.barkouch.hopital.repos;

import org.barkouch.hopital.entity.Patient;
import org.barkouch.hopital.entity.RendezVous;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PatientRepo extends JpaRepository<Patient, String> {

    List<Patient> findPatientByNomIgnoreCase(String nom);

}
