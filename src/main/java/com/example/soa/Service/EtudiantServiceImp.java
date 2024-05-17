package com.example.soa.Service;

import com.example.soa.Entity.Etudiant;
import com.example.soa.Repository.EtudiantRepository;
import org.springframework.stereotype.Service;


import java.util.List;
@Service
public class EtudiantServiceImp implements EtudiantService{
    private final EtudiantRepository etudiantRepository;
    public EtudiantServiceImp(EtudiantRepository etudiantRepository){
        this.etudiantRepository=etudiantRepository;
    }
    @Override

    public List<Etudiant> findAllEtudiants() {
        return etudiantRepository.findAll();
    }

    @Override
    public Etudiant findByCin_etudiant(Integer cin) {
        return etudiantRepository.findByCinEtudiant(cin);
    }

    @Override
    public Etudiant save(Etudiant etudiant) {
        return etudiantRepository.save(etudiant);
    }

    @Override
    public Etudiant update(Etudiant etudiant) {
        return etudiantRepository.save(etudiant);
    }

    @Override
    public void delete(Integer cin) {
        etudiantRepository.deleteByCinEtudiant(cin);
    }
}
