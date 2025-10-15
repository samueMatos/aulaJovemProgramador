package com.senac.aulaapijovemprogramador.application.dto.usuario;


import com.senac.aulaapijovemprogramador.domain.entities.Administrador;
import com.senac.aulaapijovemprogramador.domain.entities.Usuario;

public record UsuarioResponseDto(Long id, String nome, String cpf,
                                 String telefone, String email, String status) {


    public UsuarioResponseDto(Usuario usuario){
        this(
                usuario.getId(),
                usuario.getNome(),
                usuario.getCpf().getNumero(),
                usuario.getTelefone(),
                usuario.getEmail(),
                usuario.getStatus().toString()
        );
    }

    public UsuarioResponseDto(Administrador usuario){
        this(
                usuario.getId(),
                usuario.getNome(),
                usuario.getCpf().getNumero(),
                usuario.getTelefone(),
                usuario.getEmail(),
                usuario.getStatus().toString()
        );
    }
}
