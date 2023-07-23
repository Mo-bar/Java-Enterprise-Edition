package org.barkouch.ecole.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@AllArgsConstructor
@Data
@NoArgsConstructor
public class Cours {
    @Id
    private String id;
    private String nom;
    private int volumeHoraire;
    @OneToMany(mappedBy = "cours", fetch = FetchType.EAGER)
    private List<Inscription> inscriptions = new ArrayList<>();

    {
        id = UUID.randomUUID().toString();
    }
}
