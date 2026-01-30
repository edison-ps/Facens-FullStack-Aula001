/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.facens.Controllers;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;

/**
 *
 * @author edison
 */
@Controller
@RequestMapping("/hello")
public class HelloController {

    /**
     *
     * @return
     */
    @GetMapping("/teste")
    @ResponseBody

    public String meuEndPoint()
    {
        return "Hello World!!";
    }
    
    @GetMapping("/hello")
    @ResponseBody
    public String hello()
    {
        return "HELLO World!!";
    }
    
    @GetMapping("/world")
    @ResponseBody
    public String world()
    {
        return "Hello WORLD!!";
    }
    
//    @PostMapping("world/{valor}")
//    @ResponseBody
//    @ResponseStatus(HttpStatus.CREATED)
//    public String retornaValor(@PathVariable String valor)
//    {
//       return valor;
//    }
   
    @PostMapping("world/{valor1}")
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public int retornaSoma(@PathVariable int valor1, @RequestBody int valor2)
    {
        return valor1 + valor2;
    }
    
    @GetMapping("/hello/{nome}")
    @ResponseBody
    public String retornaNome(@PathVariable String nome)
    {
        return "Ola,  " + nome;
    }

    @GetMapping("/calc/soma/{a}/{b}")
    @ResponseBody
    public int soma(@PathVariable(required = false) Integer a, @PathVariable(required = false) Integer b)
    {
        if (a == null || b == null)
        {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Informe valor 'a e 'b");
        }
        return a + b;
    }
}
