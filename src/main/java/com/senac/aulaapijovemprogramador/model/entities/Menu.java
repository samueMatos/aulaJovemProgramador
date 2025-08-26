package com.senac.aulaapijovemprogramador.model.entities;

public class Menu {

    public Menu(String rota, String descricao) {
        this.descricao = descricao;
        this.rota = rota;
    }

    private Long id;
    private String descricao;
    private String rota;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getRota() {
        return rota;
    }

    public void setRota(String rota) {
        this.rota = rota;
    }
}
