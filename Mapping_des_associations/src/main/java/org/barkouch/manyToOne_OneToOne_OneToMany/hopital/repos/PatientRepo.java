package org.barkouch.manyToOne_OneToOne_OneToMany.hopital.repos;

import org.barkouch.manyToOne_OneToOne_OneToMany.hopital.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PatientRepo extends JpaRepository<Patient, String> {

    List<Patient> findPatientByNomIgnoreCase(String nom);

}
