package com.example.project_1_java_jee.bean;

import com.example.project_1_java_jee.service.EmpruntService;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named
@RequestScoped
public class EmpruntBean {

    @Inject
    private EmpruntService empruntService;
}
