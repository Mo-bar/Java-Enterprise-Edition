package org.barkouch.web;

import lombok.AllArgsConstructor;
import org.barkouch.ecole.entity.Cours;
import org.barkouch.ecole.entity.Etudiant;
import org.barkouch.ecole.repos.CoursRepo;
import org.barkouch.ecole.repos.EtudiantRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EcoleRestController {
    @Autowired
    CoursRepo coursRepo;
    @Autowired
    EtudiantRepo etudiantRepo;

    @GetMapping("/courses")
    public List<Cours> coursList(){
        return coursRepo.findAll();
    }

    @GetMapping("/etudiants")
    public List<Etudiant> etudiantsList(){
        return etudiantRepo.findAll();
    }
}
