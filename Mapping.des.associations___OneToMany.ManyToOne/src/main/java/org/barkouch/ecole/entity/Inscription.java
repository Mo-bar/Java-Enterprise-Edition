package org.barkouch.ecole.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@Entity
@AllArgsConstructor
@Data
@NoArgsConstructor
public class Inscription {
    @Id
    private String id;
    private Date date;
    private Long score;
    @ManyToOne
    private Etudiant etudiant;
    @ManyToOne
    private Cours cours;

    {
        id = UUID.randomUUID().toString();
    }
}
