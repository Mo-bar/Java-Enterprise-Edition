package org.barkouch.hopital.repos;

import org.barkouch.hopital.entity.Medecin;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface MedecinRepo extends JpaRepository<Medecin, String> {

    List<Medecin> findMedecinByNomContainingIgnoreCase(String nom);
}
