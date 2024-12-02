package com.ac.kappasisland.Controller;

import com.ac.kappasisland.Entities.ArticleEntity;
import com.ac.kappasisland.Service.ArticleService;

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
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/articles")
public class ArticleController {
    
    // Our bridge to the entity
    @Autowired
    private ArticleService articleService;

    // The get method
    @GetMapping
    public List<ArticleEntity> getAll(){
        // Return all articles in database
        return articleService.findAll();
    }

    // The delete method
    @DeleteMapping("/del/{id}")
    public void deleteArticle(@PathVariable Long id) {
        // Delete the specified element from database
        articleService.deleteArticle(id);
    }

    // The post method
    @PostMapping("/add")
    public ResponseEntity<ArticleEntity> createArticle(@RequestBody ArticleEntity article) {
        // Save the entity to the database
        ArticleEntity savedArticle = articleService.saveArticle(article);
        // Return success
        return new ResponseEntity<>(savedArticle, HttpStatus.CREATED);
    }
}
