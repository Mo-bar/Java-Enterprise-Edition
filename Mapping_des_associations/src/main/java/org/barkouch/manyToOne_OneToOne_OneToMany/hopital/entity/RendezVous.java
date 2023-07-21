package org.barkouch.manyToOne_OneToOne_OneToMany.hopital.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RendezVous {
    @Id
    private  String id;
    @Temporal(TemporalType.DATE)
    private Date dateRendezVous;
    @Enumerated(EnumType.STRING)
    private Status status;
    @ManyToOne
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Patient patient;
    @ManyToOne
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Medecin medecin;
    @OneToOne(mappedBy = "rendezVous")
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Consultation consultation;

}
