package org.barkouch.manyToOne_OneToOne_OneToMany.hopital.repos;

import org.barkouch.manyToOne_OneToOne_OneToMany.hopital.entity.RendezVous;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RendezVousRepo extends JpaRepository<RendezVous, String> {
}
