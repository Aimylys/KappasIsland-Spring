package com.ac.kappasisland.Entities;

import jakarta.persistence.*;
import jakarta.persistence.GenerationType;
import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "article")
public class ArticleEntity {

    // This represents the column of our database
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String libelle;

    @Column(nullable = false)
    private int quantity;

    @Column(nullable = false)
    private float price;


    // Getters and setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    
    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String newLib){
        this.libelle = newLib;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int newQuan){
        this.quantity = newQuan;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float newPrice){
        this.price = newPrice;
    }
}
