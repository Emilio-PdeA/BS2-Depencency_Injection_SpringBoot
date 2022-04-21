package com.example.exercise;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

@Component
@Scope(value = "prototype")
public class Ciudad {

    private String nombre;
    private Integer numeroHabitantes;
    private String contenido;

    public Ciudad (){}
    public Ciudad(String nombre, Integer numeroHabitantes){
        this.nombre = nombre;
        this.numeroHabitantes = numeroHabitantes;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getNumeroHabitantes() {
        return numeroHabitantes;
    }

    public void setNumeroHabitantes(Integer numeroHabitantes) {
        this.numeroHabitantes = numeroHabitantes;
    }

    //FUNCTIONS

    @Override
    public String toString() {
        return "{" +
                "\"nombre\":\"" + nombre + '\"' +
                ", \"numeroHabitantes\":" + numeroHabitantes +
                '}';
    }
}
