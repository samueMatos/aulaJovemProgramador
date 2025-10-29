package com.senac.aulaapijovemprogramador.application.dto.usuario;

import com.senac.aulaapijovemprogramador.application.dto.pedido.PedidoResponseDto;

import java.util.List;

public record UsuarioCriarRequestDto (String nome, String email, String senha, String cpf, boolean isAdm){
}
