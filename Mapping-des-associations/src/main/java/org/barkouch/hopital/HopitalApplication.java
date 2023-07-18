package org.barkouch.hopital;

import org.barkouch.hopital.entity.Patient;
import org.barkouch.hopital.entity.RendezVous;
import org.barkouch.hopital.repo.PatientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @SpringBootApplication: pour marquer une classe comme classe de démarrage principale.
 *
 * L’interface CommandLineRunner : est utilisée dans Spring Boot pour exécuter du code au démarrage de l’application
 *
 * @Autowired est utilisée en Spring pour rechercher les implémentations d'une interface spécifique et les injecter automatiquement.
 */
@SpringBootApplication
public class HopitalApplication implements CommandLineRunner {

	@Autowired
	private PatientRepo patientRepo;

	public static void main(String[] args) {
		SpringApplication.run(HopitalApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		RendezVous rendezVous = new RendezVous(null, new Date(), new Patient());


	}
}
