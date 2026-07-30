package com.example.project_1_java_jee.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "livres")
public class Livre {
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private long id;

    private String titre;

    private String auteur;


    private  Integer stock;

    public Livre() {
    }

    public Livre(String titre, String auteur, Integer stock){
        this.titre = titre;
        this.auteur = auteur;
        this.stock = stock;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }


    @Override
    public String toString() {
        return "Livre{" +
                "id=" + id +
                ", titre='" + titre + '\'' +
                ", auteur='" + auteur + '\'' +
                ", stock=" + stock +
                '}';
    }
}
