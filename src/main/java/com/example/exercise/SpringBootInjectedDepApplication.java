package com.example.exercise;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class SpringBootInjectedDepApplication {

	public static final String PURPLE = "\033[0;35m";  // PURPLE
	public static final String WHITE = "\033[0;37m";   // WHITE

	public static void main(String[] args) {



		ConfigurableApplicationContext context = SpringApplication.run(SpringBootInjectedDepApplication.class, args);

		System.out.println(PURPLE + "INICIAR PROGRAMA" + WHITE);

		Controlador1 contr1 = context.getBean(Controlador1.class);
		Controlador2 contr2 = context.getBean(Controlador2.class);
		Ciudad ciudad = context.getBean(Ciudad.class);
		List<Ciudad> ciudadList = new ArrayList<Ciudad>();

		ciudad.setNombre("Madrid");
		ciudad.setNumeroHabitantes(180);
		ciudadList.add(ciudad);

		contr2.setListaCiudad(ciudadList);
		contr2.addCiudad(new Ciudad("Mexico",300));


	}

}
