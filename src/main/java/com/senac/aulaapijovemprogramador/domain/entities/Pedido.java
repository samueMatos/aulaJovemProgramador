package com.senac.aulaapijovemprogramador.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pedido {

    private Long id;
    private String descricao;
    double valor;
    String status;
    double custo;

    public double cacularLucro(){
        return this.valor - this.custo;
    }

}
