package com.alurachallenge.foro_hub.topicos;


import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name = "topicos")
@Entity(name = "Topico")
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String titulo;
    private String mensaje;
    private LocalDateTime fecha;
    private String autor;
    private String curso;


    public Topico(@Valid TopicoDTO topicodto) {
        this.autor = getAutor();
        this.mensaje = getMensaje();
        this.fecha = LocalDateTime.now();
        this.titulo = topicodto.titulo();
        this.curso = topicodto.curso();
    }
}
