package com.example.demo.services;

import com.example.demo.entities.Cadre;

import java.util.Optional;

public interface CadreService {



    Iterable<Cadre> listAllCadres();

    Cadre ajouter(Cadre e );

    Optional<Cadre> getCadreById(int x);

    Cadre Update(Cadre cadre,int id) ;

    Boolean DeleteCadre(int id);








}
