package org.barkouch.ecole.repos;

import org.barkouch.ecole.entity.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;


public interface EtudiantRepo extends JpaRepository<Etudiant, String> {
}
