package com.praticandoSpringBoot.PraticandoSpring.controller;

import com.praticandoSpringBoot.PraticandoSpring.model.Usuario;
import com.praticandoSpringBoot.PraticandoSpring.repository.UsuarioRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    private final UsuarioRepository usuarioRepository;

    public UsuarioController(UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
    }

    @GetMapping("/{id}")
    public Usuario buscar(@PathVariable("id") String id){
        return usuarioRepository.findById(id).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable("id") String id){
        usuarioRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public Usuario atualizar(@PathVariable("id") String id, @RequestBody Usuario usuario){
        usuario.setId(id);
        return usuarioRepository.save(usuario);
    }

    @GetMapping
    public List<Usuario> bucarPorNome(@RequestParam("nome") String nome){
        return usuarioRepository.findByNome(nome);
    }
}
