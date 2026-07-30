package com.example.project_1_java_jee.bean;


import com.example.project_1_java_jee.entity.Livre;
import com.example.project_1_java_jee.service.LivreService;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Named
@RequestScoped
public class LivreBean {


    @Inject
    private LivreService livreService;


    @Setter
    @Getter
    private Livre livre = new Livre();


    public List<Livre> getLivres(){

        return livreService.listelivre();

    }


    public void ajouter(){

        livreService.ajouterlivre(livre);

        livre = new Livre();

    }

}