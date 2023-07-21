package org.barkouch.manyToOne_OneToOne_OneToMany.hopital.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class Patient {
    @Id
    private  String id;
    @Column(length = 50)
    private String nom;
    @Temporal(TemporalType.DATE)
    private Date dateNaiss;
    private boolean malade;
    @OneToMany(mappedBy = "patient" , fetch = FetchType.LAZY)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private List<RendezVous> rendezVous;


    public Patient(String nom, Date dateNaiss, boolean malade) {
        this.nom = nom;
        this.dateNaiss = dateNaiss;
        this.malade = malade;
    }
}
