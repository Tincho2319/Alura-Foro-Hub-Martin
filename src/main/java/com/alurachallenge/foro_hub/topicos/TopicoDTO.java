package com.alurachallenge.foro_hub.topicos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record TopicoDTO(
         @NotBlank
         String titulo,
         @NotBlank
         String mensaje,
         @NotNull
         LocalDateTime fecha,
         @NotBlank
         String autor,
         @NotBlank
         String curso
) {
    public TopicoDTO(Topico topico) {
        this(topico.getTitulo(), topico.getMensaje(), topico.getFecha(), topico.getAutor(), topico.getCurso());
    }
}
