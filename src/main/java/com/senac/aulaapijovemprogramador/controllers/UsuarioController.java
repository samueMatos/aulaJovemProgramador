package com.senac.aulaapijovemprogramador.controllers;

import com.senac.aulaapijovemprogramador.dto.UsuarioCriarRequestDto;
import com.senac.aulaapijovemprogramador.model.entities.Usuario;
import com.senac.aulaapijovemprogramador.model.repository.UsuarioRepository;
import com.senac.aulaapijovemprogramador.model.valueobjects.CPF;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
@Tag(name = "Usuarios controller",description = "Controladora responsavel por gerenciar os usuarios!")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;


    @GetMapping("/{id}")
    @Operation(summary = "Consulta de usuario por ID", description = "Médoto responsavel por consultar um unico usuario por ID e se não existir retorna null!")
    public ResponseEntity<?> buscarPorId(@PathVariable Long id){
        var usuario = usuarioRepository.findById(id).orElse(null);

        return  ResponseEntity.ok(usuario);
    }

    @PostMapping
    @Operation(summary = "Criar usuario",description = "Metodo resposavel por criar usuário")
    public ResponseEntity<?> criarUsuario(@RequestBody UsuarioCriarRequestDto usuario){
        var usuarioBanco = new Usuario(usuario);
        usuarioRepository.save(usuarioBanco);
        return ResponseEntity.ok(usuarioBanco);
    }



}
