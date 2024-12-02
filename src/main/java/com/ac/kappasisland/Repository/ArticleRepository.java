package com.ac.kappasisland.Repository;

import com.ac.kappasisland.Entities.ArticleEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface ArticleRepository extends JpaRepository<ArticleEntity, Long> {
}
