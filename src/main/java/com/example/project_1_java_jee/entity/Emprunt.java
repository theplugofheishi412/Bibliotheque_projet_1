package com.example.project_1_java_jee.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
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

}
