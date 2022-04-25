package com.example.exercise;

import com.example.exercise.controlers.Controlador1;
import com.example.exercise.controlers.Controlador2;
import com.example.exercise.models.Ciudad;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class SpringBootInjectedDepApplication {

	public static final String PURPLE = "\033[0;35m";  // PURPLE
	public static final String WHITE = "\033[0;37m";   // WHITE

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(SpringBootInjectedDepApplication.class, args);

		System.out.println(PURPLE + "INICIAR PROGRAMA" + WHITE);

		// INICIALIZAR DATOS PARA PODER TRABAJAR
		Controlador2 contr2 = context.getBean(Controlador2.class);
		contr2.setListaCiudad(new ArrayList<>());
		contr2.addCiudad(new Ciudad("Madrid",180));
		contr2.addCiudad(new Ciudad("Mexico",300));


	}

}
