package com.example.project_1_java_jee.bean;


import com.example.project_1_java_jee.entity.Livre;
import com.example.project_1_java_jee.service.LivreService;

import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;


@Named("livreBean")
@ViewScoped
public class LivreBean implements Serializable {


    @Inject
    private LivreService livreService;


    @Setter
    @Getter
    private Livre livre = new Livre();

    @Setter
    @Getter
    private Long id;


    public List<Livre> getLivres(){

        return livreService.listelivre();

    }


    public void ajouter(){

        livreService.ajouterlivre(livre);

        livre = new Livre();

    }

    public String chargerModification(Long id){
        livre = livreService.recherche(id);
        return "modifierLivre?faces-redirect=true&id=" + id;
    }

    public void chargerLivre(){
        if(id != null){
            livre = livreService.recherche(id);
        }
    }
    public String modifier(){

        livreService.modifier(livre);

        return "index?faces-redirect=true";
    }

    public String supprimer(Long id){

        Livre livre = livreService.recherche(id);

        livreService.supprimer(livre);

        return "index?faces-redirect=true";

    }

}