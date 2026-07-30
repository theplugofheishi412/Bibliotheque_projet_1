package com.example.project_1_java_jee.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.*;


@Entity
@Table(name = "livres")
public class Livre {
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Long id;

    private String titre;

    private String auteur;

    @Getter
    @Setter
    private  Integer stock;


    @OneToMany(mappedBy = "livre")
    private List<Emprunt> emprunts;

    public Livre() {
    }

    public Livre(String titre, String auteur, Integer stock){
        this.titre = titre;
        this.auteur = auteur;
        this.stock = stock;
    }

}
