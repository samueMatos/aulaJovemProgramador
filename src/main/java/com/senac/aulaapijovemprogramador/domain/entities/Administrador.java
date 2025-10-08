package com.senac.aulaapijovemprogramador.domain.entities;

public class Administrador extends Usuario {
    private boolean acessoIrrestrito;



    public boolean isAcessoIrrestrito() {
        return acessoIrrestrito;
    }

    public void setAcessoIrrestrito(boolean acessoIrrestrito) {
        this.acessoIrrestrito = acessoIrrestrito;
    }


    @Override
    public String apresentar() {
        return " Dados do Administratod Nome: "+ this.getNome() +
                " CPF Format "+ this.getCpf().toString() + " Nivel de acesso Irrestrito: "+ this.isAcessoIrrestrito();
    }
}
