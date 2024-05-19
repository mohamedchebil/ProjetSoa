package com.example.demo.controllers;

import com.example.demo.entities.Cadre;
import com.example.demo.services.CadreServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
public class controller {

    @Autowired
    CadreServiceImpl cadreService;




    // save student
    @PostMapping("/SaveCadre")
    public Cadre saveStudent(@RequestBody Cadre cadre){
        return cadreService.ajouter(cadre);


    }


    @GetMapping("/ListCadre")
    public List<Cadre> getAllStudent(){
             List<Cadre> ListAllCadre= (List<Cadre>) cadreService.listAllCadres();
        return ListAllCadre;

    }


    @GetMapping("/cadre/{id}")
    public Optional<Cadre> getStudentById(@PathVariable int id){
        return cadreService.getCadreById(id);
    }


    @PutMapping("UpdateCadre/{id}")
    public Cadre UpdateCadre(@RequestBody Cadre cadre,@PathVariable int id){
        return cadreService.Update(cadre,id);
    }

    @DeleteMapping("DeleteCadre/{id}")
    public Boolean DeleteCadre(@PathVariable int id){
        return cadreService.DeleteCadre(id);
    }


















































}
