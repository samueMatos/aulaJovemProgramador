package com.senac.aulaapijovemprogramador.model.valueobjects;

import com.fasterxml.jackson.annotation.JsonValue;

public class CPF {

    private final String cpf;

    @JsonValue
    public String getNumero() {
        return cpf;
    }

    public CPF(){
        this.cpf ="";
    }
    public CPF(String cpf) {
        this.cpf = cpf.replaceAll("[^0-9]","");
    }

    @Override
    public String toString() {
        return this.cpf;
    }
}
