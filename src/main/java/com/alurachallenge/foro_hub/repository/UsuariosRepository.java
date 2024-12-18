package com.alurachallenge.foro_hub.repository;

import com.alurachallenge.foro_hub.usuario.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UsuariosRepository extends JpaRepository<Usuarios, Long> {

    UserDetails findByLogin(String username);
}
