package com.example.project_1_java_jee.repository;

import com.example.project_1_java_jee.entity.Emprunt;
import jakarta.ejb.Stateless;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

@Stateless
public class EmpruntRepository {

    @PersistenceContext(unitName = "PERSISTENCE")
    private EntityManager entityManager;

    public void save(Emprunt emprunt){
        entityManager.persist(emprunt);
    }

    public List<Emprunt> findAll(){

        return entityManager
                .createQuery(
                        "SELECT e FROM Emprunt e",
                        Emprunt.class
                )
                .getResultList();

    }


}
