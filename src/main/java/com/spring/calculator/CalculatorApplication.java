package com.spring.calculator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// @SpringBootApplication anotacija yra lygi @Configuration, @EnableAutoConfiguration ir @ComponentScan
//Nurodome klaseje, turincioje pagrindini (main) metoda.
@SpringBootApplication
//Web Kontroleris.Pazymi MVC valdikli.Leidzia viduje naudoti @RequestMapping
//@RestContoller anotacija nurodo, jog String tipo rezultatas turetu buti isspausdinamas klientui toks koks yra.
@RestController
public class CalculatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(CalculatorApplication.class, args);
		System.out.println("Pirmoji spring boot programa");
	}
	@GetMapping("/hello")
	public String hello(@RequestParam(value = "name", defaultValue = "World") String name){
		return String.format("Hello %s!", name);
	}


}
