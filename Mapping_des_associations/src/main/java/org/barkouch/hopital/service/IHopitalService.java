package org.barkouch.hopital.service;

import org.barkouch.hopital.entity.Consultation;
import org.barkouch.hopital.entity.Medecin;
import org.barkouch.hopital.entity.Patient;
import org.barkouch.hopital.entity.RendezVous;

import java.util.List;

public interface IHopitalService {

    Patient savePatient(Patient patient);
    List<Patient> findPatientByNom(String name);

    Medecin saveMedecin(Medecin medecin);
    List<Medecin> findMedecinByNom(String name);

    RendezVous saveRDV(RendezVous rendezVous);

    Consultation saveConsultation(Consultation consultation);
}
