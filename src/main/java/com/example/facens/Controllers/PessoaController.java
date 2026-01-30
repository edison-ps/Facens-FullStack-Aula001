/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.facens.Controllers;

import com.example.facens.Models.Pessoa;
import com.example.facens.Repositories.PessoaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

/**
 *
 * @author edison
 */
@RestController
@RequestMapping("/pessoa")
public class PessoaController {
    
    @Autowired
    private PessoaRepository pessoaRepository;
    
    @GetMapping
    public List<Pessoa> getPessoas()
    {
        return pessoaRepository.findAll();
    }
    
    @GetMapping("/{id}")
    Pessoa getPessoa(@PathVariable Long id)
    {
        try
        {
            return pessoaRepository.getOne(id);
        }
        catch (Exception e)
        {
            return null;
        }
    }
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Pessoa adicionar(@RequestBody Pessoa pessoa)
    {
        return pessoaRepository.save(pessoa);
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deletePessoa(@PathVariable Long id)
    {
        pessoaRepository.deleteById(id);
    }
    
//    @PutMapping("/{id}")
//    Pessoa updatePessoa(@RequestBody Pessoa novaPessoa, @PathVariable Long id)
//    {
//        Pessoa p = pessoaRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pessoa não encontrada"));
//        p.setNome(novaPessoa.getNome());
//        return pessoaRepository.save(p);
//    }
    
    @PutMapping("/{id}")
    Pessoa updatePessoa(@RequestBody Pessoa novaPessoa, @PathVariable Long id)
    {
        Pessoa p = pessoaRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pessoa não encontrada"));
        pessoaRepository.deleteById(id);
        return pessoaRepository.save(novaPessoa);
    }
    
    @PatchMapping("/{id}")
    Pessoa updateNomePessoa(@RequestBody Pessoa novaPessoa, @PathVariable Long id)
    {
        Pessoa p = pessoaRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pessoa não encontrada"));
        p.setNome(novaPessoa.getNome());
        return pessoaRepository.save(p);
    }
    
//    private static final List<Pessoa> pessoas = new ArrayList<>();
//    
//    @PostMapping("/pessoa")
//    @ResponseBody
//    @ResponseStatus(HttpStatus.CREATED)
//    public Pessoa criar(@RequestBody Pessoa p)
//    {
//        pessoas.add(p);
//        return p;
//    }
//    
//    @GetMapping("/pessoas")
//    @ResponseBody
//    public List<Pessoa> listar()
//    {
//        return pessoas;
//    }
//    
//    @GetMapping("/pessoa/{nome}")
//    @ResponseBody
//    public Optional<Pessoa> buscar(@PathVariable String nome)
//    {
//        return pessoas.stream().filter(i -> i.getNome().equalsIgnoreCase(nome)).findFirst();
//    }
    
}
