package com.example.demo.Service;

import com.example.demo.Entity.Enseignant;
import com.example.demo.Repository.EnseignantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.OptionalDouble;

@Service
public class EnseignantService {

    private EnseignantRepository enseignantRepository;
    @Autowired
    public EnseignantService(EnseignantRepository enseignantRepository) {
        this.enseignantRepository = enseignantRepository;
    }

    //liste des enseignats
    public List<Enseignant> getAllEnseignats(){
        return enseignantRepository.findAll();
    }
    //récuperer enseignant by id
    public Enseignant getEnseignantById(Long id) {
        return enseignantRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Enseignant non trouvé avec l'ID : " + id));
    }

    //ajouter un enseignant
    public Enseignant addEnseignant(Enseignant enseignant) {
        return enseignantRepository.save(enseignant);
    }

    //update enseignant
    public Enseignant updateEnseignant(Long id, Enseignant enseignantDetails) {
        Enseignant enseignant = enseignantRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Enseignant non trouvé avec l'ID : " + id));

        enseignant.setNom(enseignantDetails.getNom());
        enseignant.setPrenom(enseignantDetails.getPrenom());
        enseignant.setMatiere(enseignantDetails.getMatiere());

        return enseignantRepository.save(enseignant);
    }

    //delete enseignant :
    public String deleteEnseignant(Long id) {
        enseignantRepository.deleteById(id);
        return "Enseignant supprimé avec succès avec l'ID : " + id;
    }
    // Calculer le taux d'absentéisme moyen
    public double calculerTauxAbsentéismeMoyen() {
        List<Enseignant> enseignants = enseignantRepository.findAll();
        OptionalDouble tauxMoyen = enseignants.stream()
                .mapToInt(Enseignant::getTauxAbsence)
                .average();
        return tauxMoyen.orElse(0.0);
    }

}
