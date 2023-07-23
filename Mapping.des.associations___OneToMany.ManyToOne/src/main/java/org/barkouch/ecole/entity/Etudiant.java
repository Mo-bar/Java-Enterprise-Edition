package org.barkouch.ecole.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@AllArgsConstructor @Data @NoArgsConstructor
public class Etudiant {
    @Id
    private String matricule;
    private String nom;
    private String prenom;
    @OneToMany(mappedBy = "etudiant", fetch = FetchType.EAGER)
    List<Inscription> inscriptions = new ArrayList<>();

    {
        matricule = UUID.randomUUID().toString();
    }
}
