package com.senac.aulaapijovemprogramador.model.entities;

import java.math.BigDecimal;

public class PedidoIFood extends Pedido {

    private double custoIFood =10;
    String codigoIfood;


    @Override
    public double cacularLucro() {
       double lucroAtual =0;
       double custoIfootPercentual = (this.custoIFood/100);
       lucroAtual = this.valor - (this.valor*custoIfootPercentual);
       lucroAtual = lucroAtual - this.custo;

        return lucroAtual;
    }
}
