package org.barkouch.ecole;

import org.barkouch.ecole.entity.*;
import org.barkouch.ecole.repos.CoursRepo;
import org.barkouch.ecole.repos.EtudiantRepo;
import org.barkouch.ecole.repos.InscriptionRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    CommandLineRunner start(CoursRepo coursRepo,
                            EtudiantRepo etudiantRepo,
                            InscriptionRepo inscriptionRepo){
        return args -> {
            Etudiant etudiant = new Etudiant();
            etudiant.setNom("Ali");
            etudiant.setPrenom("Mohammed");
            etudiantRepo.save(etudiant);

            Cours cours1 = new Cours();
            cours1.setNom("J2e");
            coursRepo.save(cours1);

            Inscription inscription = new Inscription();
            inscription.setDate(new Date());
            inscription.setEtudiant(etudiant);
            inscription.setCours(cours1);
            inscription.setScore(100L);
            Inscription res = inscriptionRepo.save(inscription);
        };
    }
}
