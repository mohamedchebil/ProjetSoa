package com.example.demo.Entity;

import jakarta.persistence.*;
@Entity
@Table(name="Enseignant")
public class Enseignant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="nom")
    private String nom;

    @Column(name="prenom")
    private String prenom;

    @Column(name="matiere")
    private String matiere;

    @Column(name="TauxAbsence")
    private int TauxAbsence;

    //constructeur non argument

    public Enseignant(){

    }

    //argument
    public Enseignant(String nom, String prenom, String matiere, int TauxAbsence){
        this.nom=nom;
        this.prenom=prenom;
        this.matiere=matiere;
        this.TauxAbsence=TauxAbsence;

    }

    //getter and setter

    public int getTauxAbsence() {
        return TauxAbsence;
    }

    public Long getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public void setTauxAbsence(int tauxAbsence) {
        TauxAbsence = tauxAbsence;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getMatiere() {
        return matiere;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setMatiere(String matiere) {
        this.matiere = matiere;
    }
}
