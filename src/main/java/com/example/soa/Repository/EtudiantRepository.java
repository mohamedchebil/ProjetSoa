package com.example.soa.Repository;

import com.example.soa.Entity.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EtudiantRepository extends JpaRepository<Etudiant,Integer> {
    Etudiant findByCinEtudiant(Integer cin);
    void deleteByCinEtudiant(Integer cin);
}
