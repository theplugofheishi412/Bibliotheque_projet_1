package com.example.project_1_java_jee.repository;

import com.example.project_1_java_jee.entity.Livre;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;


@Stateless
public class LivreRepository {


    @PersistenceContext(unitName = "PERSISTENCE")
    private EntityManager entityManager;


    public void save(Livre livre){

        entityManager.persist(livre);

    }


    public Livre findById(Long id){

        return entityManager.find(Livre.class, id);

    }


    public List<Livre> findAll(){

        return entityManager
                .createQuery(
                        "SELECT l FROM Livre l",
                        Livre.class
                )
                .getResultList();

    }


    public Livre update(Livre livre){

        return entityManager.merge(livre);

    }


    public void delete(Livre livre){

        Livre livreManaged =
                entityManager.contains(livre)
                        ? livre
                        : entityManager.merge(livre);

        entityManager.remove(livreManaged);

    }

}