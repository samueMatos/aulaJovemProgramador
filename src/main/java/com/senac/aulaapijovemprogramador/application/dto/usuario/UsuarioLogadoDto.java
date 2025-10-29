package com.senac.aulaapijovemprogramador.application.dto.usuario;

import com.senac.aulaapijovemprogramador.domain.entities.Usuario;

public record UsuarioLogadoDto(Long id, String email) {
    public UsuarioLogadoDto(Usuario usuario) {

        this(
                usuario.getId(),
                usuario.getEmail()
        );

    }
}
