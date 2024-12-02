package com.ac.kappasisland.Service;

import com.ac.kappasisland.Entities.ArticleEntity;
import com.ac.kappasisland.Repository.ArticleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService {

    // Points to the entity 
    @Autowired
    private ArticleRepository articleRepository;
    
    // Returns all the articles it can find in the database
    public List<ArticleEntity> findAll(){
        return articleRepository.findAll();
    }

    // Delete the specified article
    public void deleteArticle(Long id) {
        articleRepository.deleteById(id);
    }

    // Save the entity to the database
    public ArticleEntity saveArticle(ArticleEntity article) {
        return articleRepository.save(article);
    }
}