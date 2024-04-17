package com.spring.calculator;

import jakarta.validation.Valid;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

// Web kontroleris leidzia viduje naudoti @RequestMapping.
// @RestController anotacija nurodo , jog pvz: String tipo rezultatas turi buti ispaudinaas klientui toks koks yra
//@RestController

//@RestController nergrazina view
//Kadangi mums reikia grąžinti view pagal Spring MVC, naudojame @Controller
@Controller
// Zymi konfiguracijos komponenta viduje leidzia kurti bean per metodus su @Bean anotacija.
// Si klases lygio anotacija nurodo spring karkasui "Atspeti" konfiguracija.
// Rementis priklausomybemis ( Jar bibliotekomis ) kurios programuotojas itraukia i projekta ( Pom.xml
// Siuo atveju ji veikia kartu su main metodu.
//@EnableAutoConfiguration
public class CalculatorController {
    // Marsrutizavimo informacija. šiuo atveju, ji nurodo Spring karkasui,
    // jog visas HTTP užklausas, kurių kelias yra "/" apdoros metodas home().
    @RequestMapping(method = RequestMethod.GET, value = "/")
    public String home(Model model) {
        // Jeigu model number nepraeina validacijos - per ji grazinamos validacijos klaidos i vaizda.
        model.addAttribute("number", new Number());
        // Grąžiname JSP failą, turi būti talpinami 'webapp -> WEB-INF -> jsp' aplanke
        return "calculator";
    }
    // kadangi skaiciuotuvo forma naudoja POST metoda, cia irgi nurodome POST.
    // @RequestMapping(method = RequestMethod.POST, value = "/calculate")
    // trumpesnis POST variantas
    @PostMapping("/calculate")
    // naudotis @RequestParam reikia kai raktai skiriasi nuo frontend ir backend
    String calculate(@Valid @ModelAttribute("number") Number e, BindingResult br,
                     @RequestParam HashMap<String, String> numbers, ModelMap modelMap) {
        if (br.hasErrors()){
            return "calculator";
        }
        else {
            int num1 = Integer.parseInt(numbers.get("num1"));
            int num2 = Integer.parseInt(numbers.get("num2"));
            String operation = numbers.get("operation");
            System.out.println("Results: " + numbers.entrySet());
            //String calculate(int num1, int num2, String operation, ModelMap modelMap) {
            double result = 0;


            if(operation.equals("+")) {
                result = num1 + num2;
            } else if(operation.equals("-")) {
                result = num1 - num2;
            } else if(operation.equals("*")) {
                result = num1 * num2;
            } else if(operation.equals("/")) {
                result = (double) num1 / num2;
            }
            // ModelMap objektas naudojamas siųsti reikšmes iš Spring MVC controller į JSP
            modelMap.put("num1", num1);
            modelMap.put("num2", num2);
            modelMap.put("operation", operation);
            modelMap.put("result", result);
            // prefix + pavadinimas jsp failo + suffix
            return "calculate";


        }
    }
}