package com.senac.aulaapijovemprogramador.domain.entities;

import com.senac.aulaapijovemprogramador.application.dto.usuario.UsuarioCriarRequestDto;
import com.senac.aulaapijovemprogramador.domain.valueobjects.CPF;
import com.senac.aulaapijovemprogramador.domain.valueobjects.EnumStatusUsuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;


@Entity
@Data
@Table(name = "usuario")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo_usuario", discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("USUARIO")
@AllArgsConstructor
@NoArgsConstructor

public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String senha;

    @Column(name="tipo_usuario", insertable = false, updatable = false,nullable = true)
    private String tipo_usuario;

    @Embedded
    private CPF cpf;

    private String email;

    private String telefone;

    private EnumStatusUsuario status = EnumStatusUsuario.ATIVO;

    @ManyToMany
    @JoinTable(
            name = "menu_usuario",
            joinColumns = @JoinColumn( name = "usuario_id"),
            inverseJoinColumns = @JoinColumn(name = "menu_id")
    )
    private Set<Menu> menuAcesso;

    public Usuario (UsuarioCriarRequestDto usuario){
        this.email =usuario.email();
        this.senha = usuario.senha();
        this.cpf = new CPF(usuario.cpf());
        this.nome = usuario.nome();
    }

    public Usuario atulizarUsuarioFromDTO(Usuario usuarioBanco, UsuarioCriarRequestDto dto){
        usuarioBanco.setCpf(new CPF(dto.cpf()));
        usuarioBanco.setEmail(dto.email());
        usuarioBanco.setNome(dto.nome());
        usuarioBanco.setSenha(dto.senha());
        return usuarioBanco;
    }

    public String apresentar() {
        return " Dados "+ this.nome +
                " CPF Format "+ this.cpf.toString();
    }
}
