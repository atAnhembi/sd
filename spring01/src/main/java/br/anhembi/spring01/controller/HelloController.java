package br.anhembi.spring01.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// Bean - Objeto gerenciado pelo Spring
// Indica que essa classe é um Controller Rest
@RestController
@RequestMapping("/ola")
public class HelloController {

    @GetMapping
    public String hello() {
        return "Hello World 1";
    }

    @PostMapping
    public String hello2() {
        return "Hello World 2";
    }

    
}

// HelloController controler = new HelloController();
// controller.hello();
