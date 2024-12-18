package com.alurachallenge.foro_hub.controller;

import com.alurachallenge.foro_hub.topicos.Topico;
import com.alurachallenge.foro_hub.topicos.TopicoDTO;
import com.alurachallenge.foro_hub.repository.TopicoRepository;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    private TopicoRepository repository;

    @GetMapping
    public String devolviendoTopico(@RequestBody @Valid TopicoDTO topico) {
        return "Hello World";
    }

    @PostMapping
    public void recibiendoTopico(@RequestBody @Valid TopicoDTO topicodto) {
       repository.save(new Topico(topicodto));
    }

    @PutMapping
    public String put() {
        return "Hello World";
    }

    @DeleteMapping
    public String delete() {
        return "Hello World";
    }


}
