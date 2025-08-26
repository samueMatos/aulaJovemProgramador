package com.senac.aulaapijovemprogramador.model.valueobjects;

public class CPF {

    private final String cpf;

    public CPF(String cpf) {
        this.cpf = cpf.replaceAll("[^0-9]","");
    }

    @Override
    public String toString() {
        return this.cpf;
    }
}
