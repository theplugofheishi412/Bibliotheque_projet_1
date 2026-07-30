package com.example.project_1_java_jee.repository;

import com.example.project_1_java_jee.entity.Livre;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

import java.util.*;

@Stateless
public class LivreRepository {

    // injection de dependance de l'entityManager
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void save(Livre livre){
        entityManager.persist(livre);
    }

    public Livre findByAll(Long id){
        return entityManager.find(Livre.class,id);
    }


    public List<Livre> findAll() {

        return entityManager
                .createQuery(
                        "SELECT l FROM Livre l",
                        Livre.class
                )
                .getResultList();
    }

    @Transactional
    public Livre update(Livre livre){
       return entityManager.merge(livre);
    }


    @Transactional
    public void delete(Livre livre) {
        Livre livredelete =
                entityManager.contains(livre)
                        ? livre
                        : entityManager.merge(livre);
        entityManager.remove(livredelete);
    }

}
