package org.barkouch.hopital.repo;

import org.barkouch.hopital.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface PatientRepo extends JpaRepository<Patient, Long> {

    List<Patient> findByNomAndDateNaissAndScore(String nom, Date dateNaiss, int score);
    List<Patient> findByNomOrDateNaiss(String nom, Date dateNaiss);
}
