package com.senac.aulaapijovemprogramador.domain.entities;

public class Pedido {

    private Long id;
    private String descricao;
    double valor;
    String status;
    double custo;

    public String getDescricao() {
        return descricao ;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao+ " Pedido normal!";
    }

    public double cacularLucro(){
        return this.valor - this.custo;
    }

}
