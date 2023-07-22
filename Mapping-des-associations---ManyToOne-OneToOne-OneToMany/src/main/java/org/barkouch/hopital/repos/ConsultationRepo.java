package org.barkouch.hopital.repos;

import org.barkouch.manyToOne_OneToOne_OneToMany.hopital.entity.Consultation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultationRepo extends JpaRepository<Consultation, String> {
}
