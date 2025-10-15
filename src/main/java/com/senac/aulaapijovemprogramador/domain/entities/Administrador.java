package com.senac.aulaapijovemprogramador.domain.entities;


import com.senac.aulaapijovemprogramador.application.dto.usuario.UsuarioCriarRequestDto;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@DiscriminatorValue("ADMIN")
@NoArgsConstructor
public class Administrador extends Usuario {
    private boolean acessoIrrestrito;

    public Administrador(UsuarioCriarRequestDto usuarioRequest) {
        super(usuarioRequest);
        this.setAcessoIrrestrito(true);
    }

    @Override
    public String apresentar() {
        return " Dados do Administratod Nome: "+ this.getNome() +
                " CPF Format "+ this.getCpf().toString() + " Nivel de acesso Irrestrito: "+ this.isAcessoIrrestrito();
    }
}
