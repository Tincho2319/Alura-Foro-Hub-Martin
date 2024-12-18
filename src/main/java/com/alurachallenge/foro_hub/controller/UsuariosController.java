package com.alurachallenge.foro_hub.controller;

import com.alurachallenge.foro_hub.infra.seguridad.DatosJWTToken;
import com.alurachallenge.foro_hub.infra.seguridad.TokenService;
import com.alurachallenge.foro_hub.repository.UsuariosRepository;
import com.alurachallenge.foro_hub.usuario.Usuarios;
import com.alurachallenge.foro_hub.usuario.UsuariosDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class UsuariosController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UsuariosRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping
    public ResponseEntity autenticarUsuario(@RequestBody @Valid UsuariosDTO datosAutenticacionUsuario) {
        Authentication authToken = new UsernamePasswordAuthenticationToken(datosAutenticacionUsuario.login(),
                datosAutenticacionUsuario.clave());
        var usuarioAutenticado = authenticationManager.authenticate(authToken);
        var JWTtoken = tokenService.generarToken((Usuarios) usuarioAutenticado.getPrincipal());
        return ResponseEntity.ok(new DatosJWTToken(JWTtoken));
    }

    @PostMapping("/registro")
    public ResponseEntity<String> registrarUsuario(@RequestBody @Valid UsuariosDTO usuarioDTO) {
        // Encripta la contraseña antes de guardar
        String contraseñaEncriptada = passwordEncoder.encode(usuarioDTO.clave());

        // Crea y guarda el usuario
        Usuarios nuevoUsuario = new Usuarios(usuarioDTO);
        nuevoUsuario.setClave(contraseñaEncriptada); // Asigna la contraseña encriptada
        repository.save(nuevoUsuario);

        return ResponseEntity.ok("Usuario registrado con éxito");
    }
}
