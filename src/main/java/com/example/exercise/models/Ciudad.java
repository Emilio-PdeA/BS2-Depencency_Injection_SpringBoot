package com.example.exercise.models;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

@Component
@Scope(value = "prototype")
public class Ciudad {

    private String nombre;
    private Integer numeroHabitantes;

    public Ciudad (){}
    public Ciudad(String nombre, Integer numeroHabitantes){
        this.nombre = nombre;
        this.numeroHabitantes = numeroHabitantes;
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
}
