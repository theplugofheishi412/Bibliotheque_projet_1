package com.example.project_1_java_jee.service;

import com.example.project_1_java_jee.entity.Emprunt;
import com.example.project_1_java_jee.entity.Livre;
import com.example.project_1_java_jee.exception.StockInsuffisantException;
import com.example.project_1_java_jee.repository.EmpruntRepository;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

/**
 *
 */
@Stateless
public class EmpruntService {

    @Inject
    private EmpruntRepository empruntRepository;

    public void emprunterlivre(Emprunt emprunt)throws StockInsuffisantException {

        Livre livre = emprunt.getLivre();

        if(livre.getStock() <= 0) {

            throw new StockInsuffisantException(
                    "Impossible d'emprunter ce livre : stock épuisé"
            );
        }


        livre.setStock(
                livre.getStock() - 1
        );
        empruntRepository.save(emprunt);

    }
}
