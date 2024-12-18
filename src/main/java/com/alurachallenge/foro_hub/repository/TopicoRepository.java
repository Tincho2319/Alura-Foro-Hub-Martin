package com.alurachallenge.foro_hub.repository;

import com.alurachallenge.foro_hub.topicos.Topico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicoRepository extends JpaRepository<Topico, Long> {
}
