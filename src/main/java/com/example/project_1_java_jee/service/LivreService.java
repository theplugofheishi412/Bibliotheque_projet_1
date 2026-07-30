package com.example.project_1_java_jee.service;


import com.example.project_1_java_jee.repository.LivreRepository;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import com.example.project_1_java_jee.entity.Livre;
import java.util.*;


@Stateless
public class LivreService {

    @Inject
    private LivreRepository livrerepository;

    public void ajouterlivre(Livre livre){
        livrerepository.save(livre);
    }

    public List<Livre>listelivre(){
       return livrerepository.findAll();
    }

    public Livre recherche(Long id){
       return livrerepository.findById(id);
    }

    public Livre modifier (Livre livre){
      return livrerepository.update(livre);
    }

    public void supprimer (Livre livre){
        livrerepository.delete(livre);
    }







}
