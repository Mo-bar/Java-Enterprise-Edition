package org.barkouch.ecole.repos;

import org.barkouch.ecole.entity.Inscription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InscriptionRepo extends JpaRepository<Inscription, String> {
}
