package com.example.exercise;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@Component
//@Scope(value = "prototype")
public class Controlador1 {

    public static final String CYAN = "\033[0;36m";    // CYAN
    static final String urlBase = "/controlador1";
    @Autowired
    Controlador2 contr2;


    /*
     * METHOD: POST
     * Test URL: localhost:8080/controlador1/addPersona
     * BODY (JSON): {"nombre":$nombre, "ciudad":$ciudad, "edad":$edad}
     * RESPONSE: {"msg":"Persona agregada"}
     * */
    @PostMapping(path = urlBase + "/addPersona", consumes = "application/json")
    public ResponseEntity<String> addPersona(@RequestBody Persona persona){
        contr2.setPersona(persona);
        System.out.println(CYAN +"POST: " + urlBase + "/addPersona");
        return new ResponseEntity<>(contr2.getPerson(), HttpStatus.OK);
    }

    /*
     * METHOD: POST
     * Test URL: localhost:8080/controlador1/addCiudad
     * BODY (JSON): {"nombre":$nombre, "numeroHabitantes":#numHabitantes}
     * RESPONSE: {"msg":"Ciudad Agregada"}
     * */
    @PostMapping(path = urlBase + "/addCiudad", consumes = "application/json")
    public ResponseEntity<String> addCiudad(@RequestBody Ciudad ciudad){
        System.out.println(CYAN + "POST: " + urlBase + "/addCiudad");
        contr2.addCiudad(ciudad);
    return new ResponseEntity<>(contr2.getCiudad(), HttpStatus.OK);
    }

    public Controlador1(){}


}
