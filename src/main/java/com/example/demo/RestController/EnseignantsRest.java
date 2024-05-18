package com.example.demo.RestController;


import com.example.demo.Entity.Enseignant;
import com.example.demo.Service.EnseignantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/enseignants")
public class EnseignantsRest {

    private EnseignantService enseignantService;

    @Autowired
    public EnseignantsRest(EnseignantService enseignantService) {
        this.enseignantService = enseignantService;
    }

    @GetMapping("/getall")
    public List<Enseignant> getAllEnseignants() {
        return enseignantService.getAllEnseignats();
    }

    @GetMapping("/{id}")
    public Enseignant getEnseignantById(@PathVariable Long id) {
        return enseignantService.getEnseignantById(id);
    }
    @PostMapping("/addenseignant")
    public Enseignant addEnseignant(@RequestBody Enseignant enseignant) {
        return enseignantService.addEnseignant(enseignant);
    }

    @PutMapping("/update/{id}")
    public Enseignant updateEnseignant(@PathVariable Long id, @RequestBody Enseignant enseignantDetails) {
        return enseignantService.updateEnseignant(id, enseignantDetails);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteEnseignant(@PathVariable Long id) {
        return enseignantService.deleteEnseignant(id);
    }

    @GetMapping("/statistiques/taux-absence")
    public double getTauxAbsentéismeMoyen() {
        return enseignantService.calculerTauxAbsentéismeMoyen();
    }



}
