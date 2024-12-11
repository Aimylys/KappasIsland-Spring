package com.ac.kappasisland.Controller;

import com.ac.kappasisland.Entities.Objet;
import com.ac.kappasisland.Service.ObjetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:52804")
@RequestMapping("/api/objet")
public class ObjetBDDController {
    
    // Passerelle vers l’entité Objet
    @Autowired
    private ObjetService objetService;

    // Méthode get
    @GetMapping
    public List<Objet> getAll(){
        // Retourne tout les objets de la database
        return objetService.findAll();
    }

    // Méthode delete
    @DeleteMapping("/del/{id}")
    public void deleteObjet(@PathVariable Long id) {
        // Supprime un élément spécifique de la database
        objetService.deleteObjet(id);
    }

    // Méthode post
    @PostMapping("/add")
    public ResponseEntity<Objet> createObjet(@RequestBody Objet objet) {
        // Enregistrer l’entité dans la base de données
        Objet savedObjet = objetService.saveObjet(objet);
        // Retourne succès
        return new ResponseEntity<>(savedObjet, HttpStatus.CREATED);
    }
}
