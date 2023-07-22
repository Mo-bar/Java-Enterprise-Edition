package org.barkouch.hopital.service;

import org.barkouch.hopital.repos.RendezVousRepo;
import org.barkouch.manyToOne_OneToOne_OneToMany.hopital.entity.Consultation;
import org.barkouch.manyToOne_OneToOne_OneToMany.hopital.entity.Medecin;
import org.barkouch.manyToOne_OneToOne_OneToMany.hopital.entity.Patient;
import org.barkouch.manyToOne_OneToOne_OneToMany.hopital.entity.RendezVous;
import org.barkouch.manyToOne_OneToOne_OneToMany.hopital.repos.ConsultationRepo;
import org.barkouch.manyToOne_OneToOne_OneToMany.hopital.repos.MedecinRepo;
import org.barkouch.manyToOne_OneToOne_OneToMany.hopital.repos.PatientRepo;
import org.barkouch.manyToOne_OneToOne_OneToMany.hopital.repos.RendezVousRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HopitalService implements IHopitalService{
    @Autowired
    PatientRepo patientRepo;
    @Autowired
    MedecinRepo medecinRepo;
    @Autowired
    RendezVousRepo rendezVousRepo;
    @Autowired
    ConsultationRepo consultationRepo;

    @Override
    public Patient savePatient(Patient patient) {
        final String id = UUID.randomUUID().toString();
        patient.setId(id);
        return patientRepo.save(patient);
    }

    @Override
    public List<Patient> findPatientByNom(String name) {
        return patientRepo.findPatientByNomIgnoreCase(name);
    }

    @Override
    public Medecin saveMedecin(Medecin medecin) {
        final String id = UUID.randomUUID().toString();
        medecin.setId(id);
        return medecinRepo.save(medecin);
    }

    @Override
    public List<Medecin> findMedecinByNom(String name) {
        return medecinRepo.findMedecinByNomContainingIgnoreCase(name);
    }

    @Override
    public RendezVous saveRDV(RendezVous rendezVous) {
        final String id = UUID.randomUUID().toString();
        rendezVous.setId(id);
        return rendezVousRepo.save(rendezVous);
    }

    @Override
    public Consultation saveConsultation(Consultation consultation) {
        final String id = UUID.randomUUID().toString();
        consultation.setId(id);
        return consultationRepo.save(consultation);
    }


}
