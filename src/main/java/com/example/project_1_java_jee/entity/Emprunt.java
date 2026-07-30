package com.example.project_1_java_jee.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "emprunts")
public class Emprunt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomEmpreteur;

    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "livre_id")
    private Livre livre;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomEmpreteur() {
        return nomEmpreteur;
    }

    public void setNomEmpreteur(String nomEmpreteur) {
        this.nomEmpreteur = nomEmpreteur;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Livre getLivre() {
        return livre;
    }

    public void setLivre(Livre livre) {
        this.livre = livre;
    }
}
