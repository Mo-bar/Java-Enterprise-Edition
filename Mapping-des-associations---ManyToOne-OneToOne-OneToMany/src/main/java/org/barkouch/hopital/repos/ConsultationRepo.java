package org.barkouch.hopital.repos;


import org.barkouch.hopital.entity.Consultation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultationRepo extends JpaRepository<Consultation, String> {
}
