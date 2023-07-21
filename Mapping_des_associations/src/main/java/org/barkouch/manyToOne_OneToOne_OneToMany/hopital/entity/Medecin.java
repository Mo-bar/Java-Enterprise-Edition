package org.barkouch.manyToOne_OneToOne_OneToMany.hopital.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Medecin {
    @Id
    private  String id;
    private String nom;
    private String email;
    private String specialite;
    @OneToMany(mappedBy = "medecin" ,fetch = FetchType.LAZY)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<RendezVous> rendezVous;

    public Medecin(String nom, String email, String specialite) {
        this.nom = nom;
        this.email = email;
        this.specialite = specialite;
    }
}
