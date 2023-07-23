package org.barkouch.hopital.service;

import org.barkouch.hopital.entity.*;

import java.util.List;

public interface IHopitalService {

    Patient savePatient(Patient patient);
    List<Patient> findPatientByNom(String name);

    Medecin saveMedecin(Medecin medecin);
    List<Medecin> findMedecinByNom(String name);

    RendezVous saveRDV(RendezVous rendezVous);

    Consultation saveConsultation(Consultation consultation);
}
