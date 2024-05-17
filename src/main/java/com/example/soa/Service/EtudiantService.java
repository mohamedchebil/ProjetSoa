package com.example.soa.Service;

import com.example.soa.Entity.Etudiant;

import java.util.List;

public interface EtudiantService {
    List<Etudiant> findAllEtudiants();
    Etudiant findByCin_etudiant(Integer cin);
    Etudiant save(Etudiant etudiant);
    Etudiant update(Etudiant etudiant);
    void delete(Integer cin);
}
