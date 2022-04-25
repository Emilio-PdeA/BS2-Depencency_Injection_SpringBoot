package com.example.exercise.controlers;

import com.example.exercise.models.Ciudad;
import com.example.exercise.models.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/controlador1")
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
    @PostMapping(path = "/addPersona", consumes = "application/json")
    public ResponseEntity<Persona> addPersona(@RequestBody Persona persona){
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
    @PostMapping(path = "/addCiudad", consumes = "application/json")
    public ResponseEntity<List<Ciudad>> addCiudad(@RequestBody Ciudad ciudad){
        System.out.println(CYAN + "POST: " + urlBase + "/addCiudad");
        contr2.addCiudad(ciudad);
    return new ResponseEntity<>(contr2.listaCiudad, HttpStatus.OK);
    }

    public Controlador1(){}


}
