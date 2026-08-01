package com.example.project_1_java_jee.service;

import com.example.project_1_java_jee.entity.Emprunt;
import com.example.project_1_java_jee.entity.Livre;
import com.example.project_1_java_jee.exception.StockInsuffisantException;
import com.example.project_1_java_jee.repository.EmpruntRepository;
import com.example.project_1_java_jee.repository.LivreRepository;
import jakarta.ejb.TransactionAttribute;
import jakarta.ejb.TransactionAttributeType;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

/**
 *
 */
@Stateless
public class EmpruntService {

    @Inject
    private EmpruntRepository empruntRepository;

    @Inject
    private LivreRepository livreRepository;

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void emprunterlivre(Emprunt emprunt) throws StockInsuffisantException {
        if (emprunt == null || emprunt.getLivre() == null || emprunt.getLivre().getId() == null) {
            throw new IllegalArgumentException("Emprunt ou livre invalide");
        }

        // charger l'entité Livre managée depuis la base
        Livre livre = livreRepository.findById(emprunt.getLivre().getId());
        if (livre == null) {
            throw new IllegalArgumentException("Livre introuvable");
        }

        Integer stock = livre.getStock();
        if (stock == null || stock <= 0) {
            throw new StockInsuffisantException("Impossible d'emprunter ce livre : stock épuisé");
        }

        // diminution du stock
        livre.setStock(stock - 1);

        // sauvegarde du nouveau stock (merge retourne l'entité managée)
        livre = livreRepository.update(livre);

        // s'assurer que l'emprunt référence l'entité managée
        emprunt.setLivre(livre);

        // sauvegarde de l'emprunt
        empruntRepository.save(emprunt);
    }

    public java.util.List<Emprunt> listeEmprunts() {
        return empruntRepository.findAll();
    }
}
