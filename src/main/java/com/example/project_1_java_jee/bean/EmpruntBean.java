package com.example.project_1_java_jee.bean;


import com.example.project_1_java_jee.entity.Emprunt;
import com.example.project_1_java_jee.entity.Livre;
import com.example.project_1_java_jee.exception.StockInsuffisantException;
import com.example.project_1_java_jee.service.EmpruntService;
import com.example.project_1_java_jee.service.LivreService;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.time.LocalDate;


@Named("empruntBean")
@RequestScoped
public class EmpruntBean {


    @Inject
    private EmpruntService empruntService;


    @Inject
    private LivreService livreService;



    @Setter
    @Getter
    private Emprunt emprunt;


    @Getter
    private List<Emprunt> emprunts;


    @Getter
    private List<Livre> livres;

    @Setter
    @Getter
    private Long selectedLivreId;



    @PostConstruct
    public void init(){

        // Charger tous les emprunts
        emprunts = empruntService.listeEmprunts();

        // Charger les livres pour le formulaire
        livres = livreService.listelivre();

        // Préparer un nouvel emprunt
        emprunt = new Emprunt();
        // selectedLivreId permet de choisir le livre via son id dans la page
        selectedLivreId = null;

    }




    public void ajouter(){


        try {


                // assigner le livre sélectionné à l'emprunt
                if (selectedLivreId == null) {
                    throw new IllegalArgumentException("Veuillez sélectionner un livre");
                }
                emprunt.setLivre(livreService.recherche(selectedLivreId));

                // fixer la date de l'emprunt
                emprunt.setDate(LocalDate.now());

                // Appel de la règle métier
                empruntService.emprunterlivre(emprunt);

                // Nouveau formulaire vide
                emprunt = new Emprunt();
                selectedLivreId = null;

                // Rafraîchir la liste
                emprunts = empruntService.listeEmprunts();


        } catch (StockInsuffisantException | IllegalArgumentException e) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), null));
        }


    }


}