package com.example.soa.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Etudiant {
    @Id
    private Integer cinEtudiant;
    @Column
    private String nomEtudiant;
    @Column
    private String prenomEtudiant;
    @Column
    private float moyenne;
}
