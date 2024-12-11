package com.ac.kappasisland.Service;

import com.ac.kappasisland.Entities.Objet;
import com.ac.kappasisland.Repository.ObjetRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ObjetService {

    // Pointe vers l'entité
    @Autowired
    private ObjetRepository objetRepository;
    
    // Retourne tout les objets qu'il trouve dans la database
    public List<Objet> findAll(){
        return objetRepository.findAll();
    }

    // Supprime un objet spécifique
    public void deleteObjet(Long id) {
        objetRepository.deleteById(id);
    }

    // // Enregistrer l’entité dans la base de données
    public Objet saveObjet(Objet objet) {
        return objetRepository.save(objet);
    }
}