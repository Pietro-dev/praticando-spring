package com.praticandoSpringBoot.PraticandoSpring.repository;

import com.praticandoSpringBoot.PraticandoSpring.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsuarioRepository extends JpaRepository<Usuario, String> {

    List<Usuario> findByNome(String nome);
}
