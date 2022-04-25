package com.example.exercise.controlers;

import com.example.exercise.models.Ciudad;
import com.example.exercise.models.Persona;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@Component
//@Scope(value = "prototype")
public class Controlador2 {

    public static final String GREEN = "\033[0;32m";
    static final String urlBase = "/controlador2";
    @Autowired
    List<Ciudad> listaCiudad = new ArrayList<>();

    @Autowired
    private Persona persona;

    /*
     * METHOD: GET
     * Test URL: localhost:8080/controlador2/getPersona
     * Response: Object<Persona>
     */
    @GetMapping(urlBase + "/getPersona")
    public Persona getPerson(){
        System.out.println(GREEN + "GET: " + urlBase + "/getPersona");
        return persona;
    }

    /*
     * METHOD: GET
     * Test URL: localhost:8080/controlador2/getCiudad
     * Response: List<Ciudad>
     */
    @GetMapping(path = urlBase + "/getCiudad")
    public List<Ciudad> getCiudad(){
        System.out.println(GREEN + "GET: " + urlBase + "/getCiudad");
        return listaCiudad;
    }

    public void setPersona(Persona pers){
        this.persona = pers;
        persona.setEdad(2 * persona.getEdad());
    }

    public String printPersona(){
        return persona.toString();
    }

    public void setListaCiudad(List<Ciudad> lc){
        this.listaCiudad = lc;
    }

    public void addCiudad(Ciudad city){
        listaCiudad.add(city);
    }

    public Controlador2(){}


}
