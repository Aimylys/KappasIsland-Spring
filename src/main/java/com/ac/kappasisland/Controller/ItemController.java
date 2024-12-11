package com.ac.kappasisland.Controller;

import com.ac.kappasisland.Entities.Objet;
import com.ac.kappasisland.Service.ObjetService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "https://zelda.fanapis.com/")
@RequestMapping("/api/items")
public class ItemController {
    
    // Our bridge to the entity
    @Autowired
    private ObjetService itemService;

    // The get method
    @GetMapping("/{id}")
    public List<Objet> getAll(){
        // Return all articles in database
        return itemService.findAll();
    }

    /*// The post method
    @PostMapping("/add")
    public ResponseEntity<Objet> createItem(@RequestBody Objet item) {
        // Save the entity to the database
        Objet savedItem = itemService.saveItem(item);
        // Return success
        return new ResponseEntity<>(savedItem, HttpStatus.CREATED);
    }*/
}
