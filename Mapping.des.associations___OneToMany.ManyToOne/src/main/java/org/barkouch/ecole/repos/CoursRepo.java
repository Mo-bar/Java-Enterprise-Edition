package org.barkouch.ecole.repos;

import org.barkouch.ecole.entity.Cours;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;


public interface CoursRepo extends JpaRepository<Cours, String> {
}
