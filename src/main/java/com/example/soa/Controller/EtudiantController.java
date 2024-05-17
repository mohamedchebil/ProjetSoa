package com.example.soa.Controller;

import com.example.soa.Entity.Etudiant;
import com.example.soa.Service.EtudiantService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/etudiant")
public class EtudiantController {
    private final EtudiantService etudiantService;
    public EtudiantController(EtudiantService etudiantService){
        this.etudiantService=etudiantService;
    }

    @GetMapping
    public List<Etudiant> findAllEtudiants(){
        return etudiantService.findAllEtudiants();
    }
    @GetMapping("/{cin}")
    public Etudiant findByCin_etudiant(@PathVariable Integer cin){
        return etudiantService.findByCin_etudiant(cin);
    }
    @PostMapping("/add")
    public Etudiant save(@RequestBody Etudiant etudiant){
        return etudiantService.save(etudiant);
    }
    @PutMapping("/update")
    public Etudiant update(@RequestBody Etudiant etudiant){
        return etudiantService.update(etudiant);
    }
    @DeleteMapping("/delete/{cin}")
    @Transactional
    public String delete(@PathVariable Integer cin){
        etudiantService.delete(cin);
        return "delete successfully";
    }
}
