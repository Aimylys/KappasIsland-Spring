package com.ac.kappasisland.Repository;

import com.ac.kappasisland.Entities.Objet;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface ObjetRepository extends JpaRepository<Objet, Long> {
}
