package com.ac.kappasisland.Controller;

import com.ac.kappasisland.Entities.ItemEntity;
import com.ac.kappasisland.Service.ItemService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:52804")
@RequestMapping("/api/items")
public class ArticleController {
    
    // Our bridge to the entity
    @Autowired
    private ItemService itemService;

    // The get method
    @GetMapping
    public List<ItemEntity> getAll(){
        // Return all articles in database
        return itemService.findAll();
    }

    // The delete method
    @DeleteMapping("/del/{id}")
    public void deleteItem(@PathVariable Long id) {
        // Delete the specified element from database
        itemService.deleteItem(id);
    }

    // The post method
    @PostMapping("/add")
    public ResponseEntity<ItemEntity> createItem(@RequestBody ItemEntity item) {
        // Save the entity to the database
        ItemEntity savedItem = itemService.saveItem(item);
        // Return success
        return new ResponseEntity<>(savedItem, HttpStatus.CREATED);
    }
}
