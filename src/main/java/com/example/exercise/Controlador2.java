package com.example.exercise;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RestController
@Component
//@Scope(value = "prototype")
public class Controlador2 {

    public static final String GREEN = "\033[0;32m";
    static final String urlBase = "/controlador2";
    @Autowired
    List<Ciudad> listaCiudad = new ArrayList<Ciudad>();

    @Autowired
    private Persona persona;

    /*
     * METHOD: GET
     * Test URL: localhost:8080/controlador2/getPersona
     * Response: Object<Persona>
     */
    @GetMapping(urlBase + "/getPersona")
    public String getPerson(){
        System.out.println(GREEN + "GET: " + urlBase + "/getPersona");
        return persona.toString();
    }

    /*
     * METHOD: GET
     * Test URL: localhost:8080/controlador2/getCiudad
     * Response: List<Ciudad>
     */
    @GetMapping(path = urlBase + "/getCiudad")
    public String getCiudad(){
        System.out.println(GREEN + "GET: " + urlBase + "/getCiudad");
        String jsonResponse = "[";
        Iterator<Ciudad> ciudadIterator = listaCiudad.iterator();
        while(ciudadIterator.hasNext()){
            jsonResponse += ciudadIterator.next().toString() + ",";
        }
        jsonResponse = jsonResponse.substring(0,jsonResponse.length()-1) + "]";
        return jsonResponse;
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
