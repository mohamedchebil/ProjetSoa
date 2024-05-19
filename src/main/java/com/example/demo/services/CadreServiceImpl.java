package com.example.demo.services;

import com.example.demo.entities.Cadre;
import com.example.demo.repositories.CadreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CadreServiceImpl implements CadreService{

    @Autowired
    CadreRepository cadreRepository;

    @Autowired
    public CadreServiceImpl(CadreRepository cadreRepository) {
        this.cadreRepository = cadreRepository;
    }

    @Override
    public Iterable<Cadre> listAllCadres() {
        return cadreRepository.findAll();
    }

    @Override
    public Cadre ajouter(Cadre e) {
        System.out.println("ajout en couurs");
        return  cadreRepository.save(e);
    }

    @Override
    public Optional<Cadre> getCadreById(int x) {
        return cadreRepository.findById(x);
    }

    @Override
    public Cadre Update(Cadre cadre,int id) {
        Optional<Cadre> existingCadre = getCadreById(id);
        if (existingCadre != null){

            return cadreRepository.save(cadre);
        } else {
            return null;

        }

    }

    @Override
    public Boolean DeleteCadre(int id) {
        Optional<Cadre> optional = cadreRepository.findById(id);
        System.out.println(optional);
        if (optional.isPresent()){
            cadreRepository.delete(optional.get());
            return true;
        } else return false;

    }










}
