package com.alurachallenge.foro_hub.usuario;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UsuariosDTO(
    @NotBlank
    @Size(min = 2, max = 20)
    String login,
    @NotBlank
    @Size(min = 5, max = 20)
    String clave,
    @NotBlank
    @Email
    String email
) {

    public UsuariosDTO(Usuarios usuarios){
        this(usuarios.getLogin(),usuarios.getClave(),usuarios.getEmail());
    }
}
