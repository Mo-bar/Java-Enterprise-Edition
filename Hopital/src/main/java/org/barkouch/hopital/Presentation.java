package org.barkouch.hopital;


import org.barkouch.hopital.entity.*;
import org.barkouch.hopital.service.IHopitalService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.Date;

@SpringBootApplication
public class Presentation {

    public static void main(String[] args) {
        SpringApplication.run(Presentation.class, args);
    }

    @Bean
    CommandLineRunner start(IHopitalService hopitalService){
        return args -> {
          for(String name : Arrays.asList("Ali","Joe","Moe")){
                hopitalService.savePatient(new Patient(null,name,new Date(),Math.random() > 0.5 ,null));
            }

            for( String name : Arrays.asList("Foead", "Fadwa","Ahmed")){
                hopitalService.saveMedecin(new Medecin(null,"Dr."+name,name+"@gmail.com","Dentist(e)",null));
            }


            final Patient patient = hopitalService.findPatientByNom("ali").get(0);
            final Medecin medecin = hopitalService.findMedecinByNom("dr").get(0);

            RendezVous rendezVous = new RendezVous();
            rendezVous.setDateRendezVous(new Date());
            rendezVous.setStatus(Status.RESERVE);
            rendezVous.setMedecin(medecin);
            rendezVous.setPatient(patient);
            hopitalService.saveRDV(rendezVous);


            RendezVous rendezVous2 = new RendezVous();
            rendezVous.setDateRendezVous(new Date(2023,12,03));
            rendezVous.setStatus(Status.ANNELE);
            rendezVous.setMedecin(medecin);
            rendezVous.setPatient(patient);
            RendezVous rdv1 = hopitalService.saveRDV(rendezVous2);
            System.out.println(rdv1.toString());

            Consultation consultation = new Consultation();
            consultation.setRendezVous(rendezVous);
            consultation.setRapport("rapport .......");
            consultation.setDateConsultation(new Date());
            hopitalService.saveConsultation(consultation);


          Patient p1 = hopitalService.findPatientByNom("ali").get(0);
            System.out.println(p1.getRendezVous().get(0).getStatus());

        };
    }

}
