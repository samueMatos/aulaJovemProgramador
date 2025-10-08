package com.senac.aulaapijovemprogramador.domain.valueobjects;

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

        if(cpf == null || !isCPFValido(cpf)){
            throw  new IllegalArgumentException("CPF Invalido");
        }

        this.cpf = cpf.replaceAll("[^0-9]","");

    }

    @Override
    public String toString() {
        return this.cpf;
    }

    public boolean isCPFValido(String cpf){

        String cpfNumeros = cpf.replaceAll("[^0-9]","");

        if (cpfNumeros.length() != 11 || cpfNumeros.matches("(\\d)\\1{10}")) {
            return false;
        }

        return validaDigitoVerificadorCpf(cpf);
    }

    public boolean validaDigitoVerificadorCpf(String cpf) {
        try {
            int soma = 0;
            int peso = 10;

            // Calcula o primeiro dígito verificador
            for (int i = 0; i < 9; i++) {
                int num = Character.getNumericValue(cpf.charAt(i));
                soma += num * peso--;
            }

            int primeiroDigito = 11 - (soma % 11);
            if (primeiroDigito >= 10) primeiroDigito = 0;

            // Verifica o primeiro dígito
            if (primeiroDigito != Character.getNumericValue(cpf.charAt(9))) {
                return false;
            }

            // Calcula o segundo dígito verificador
            soma = 0;
            peso = 11;
            for (int i = 0; i < 10; i++) {
                int num = Character.getNumericValue(cpf.charAt(i));
                soma += num * peso--;
            }

            int segundoDigito = 11 - (soma % 11);
            if (segundoDigito >= 10) segundoDigito = 0;

            // Verifica o segundo dígito
            return segundoDigito == Character.getNumericValue(cpf.charAt(10));

        } catch (Exception e) {
            return false;
        }
    }
}
