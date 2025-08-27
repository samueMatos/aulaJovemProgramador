package com.senac.aulaapijovemprogramador.controllers;

import com.senac.aulaapijovemprogramador.model.entities.Usuario;
import com.senac.aulaapijovemprogramador.model.valueobjects.CPF;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @GetMapping("/{id}")
    public Usuario buscarPorId(@PathVariable Long id){
        var usuario = new Usuario();

		usuario.setId(id);
		usuario.setNome("Samuel Matos");
		usuario.setCpf(new CPF("063.720.145-20"));
		usuario.setEmail("samuel.matos@prof.sc.senac.br");
		usuario.setTelefone("+55048999655451");

        return usuario;
    }
}
