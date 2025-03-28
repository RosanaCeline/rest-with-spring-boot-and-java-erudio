package RosanaCeline.controllers;

import RosanaCeline.model.Greeting;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

// Indica que essa classe eh um controlador REST do Spring Boot, que retorna respostas JSON
@RestController
public class GreetingController {

    // Template da mensagem de saudacao (Greeting)
    private static final String template = "Hello, %s!";

    // Contador atomico pra gerar IDs unicos para cada requisicao
    private final AtomicLong counter = new AtomicLong();

    // Query Params - Parametro opcional
    // http://localhost:8080/greeting?name=Leandro

    // Define um endpoint acessivel por aquele URL // http://localhost:8080/greeting
    @RequestMapping("/greeting")
    public Greeting greeting(
            // Obtem o parametro name da requisicao. Se nao for informado, usa "World" como padrao
            @RequestParam(value = "name", defaultValue = "World")
            String name){

        // Retorna um objeto da classe Greeting com um ID unico e a mensagem formatada
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }
}
