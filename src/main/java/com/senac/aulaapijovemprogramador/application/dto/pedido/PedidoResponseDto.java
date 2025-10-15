package com.senac.aulaapijovemprogramador.application.dto.pedido;

import com.senac.aulaapijovemprogramador.domain.entities.Pedido;

public record PedidoResponseDto(String discricao, double valor, String empresa, long qtd) {
    public PedidoResponseDto(Pedido pedido) {
        this(
                pedido.getDescricao(),
                pedido.getValor(),
                pedido.getEmpresa().getNomeFantasia(),
                pedido.getEmpresa().getPedidos().stream().count()
        );
    }
}
