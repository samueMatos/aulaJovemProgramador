package com.senac.aulaapijovemprogramador.model.entities;

import com.senac.aulaapijovemprogramador.model.valueobjects.CPF;

import java.util.List;

public class Usuario {

    private Long id;

    private String nome;

    private String senha;

    private CPF cpf;

    private String email;

    private String telefone;

    private List<Menu> menuAcesso;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public CPF getCpf() {
        return cpf;
    }

    public void setCpf(CPF cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public List<Menu> getMenuAcesso() {
        return menuAcesso;
    }

    public void setMenuAcesso(List<Menu> menuAcesso) {
        this.menuAcesso = menuAcesso;
    }

    public String apresentar() {
        return " Dados "+ this.nome +
                " CPF Format "+ this.cpf.toString();
    }
}
