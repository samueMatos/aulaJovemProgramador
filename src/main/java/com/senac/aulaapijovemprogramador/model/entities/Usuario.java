package com.senac.aulaapijovemprogramador.model.entities;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.senac.aulaapijovemprogramador.dto.UsuarioCriarRequestDto;
import com.senac.aulaapijovemprogramador.model.valueobjects.CPF;
import jakarta.persistence.*;

import java.util.List;


@Entity
public class Usuario {

    public Usuario(){}

    public Usuario (UsuarioCriarRequestDto usuario){
        this.email =usuario.email();
        this.senha = usuario.senha();
        this.cpf = new CPF(usuario.cpf());
        this.nome = usuario.nome();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String senha;


    @Embedded
    private CPF cpf;

    private String email;

    private String telefone;

    @OneToMany
    @JoinColumn(name = "usuario_id",nullable = true)
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
