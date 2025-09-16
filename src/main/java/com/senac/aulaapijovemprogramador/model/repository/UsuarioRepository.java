package com.senac.aulaapijovemprogramador.model.repository;

import com.senac.aulaapijovemprogramador.model.entities.Usuario;
import com.senac.aulaapijovemprogramador.model.valueobjects.EnumStatusUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Long> {

    Optional<Usuario> findByCpf_CpfAndStatusNot(String cpf, EnumStatusUsuario status);

    boolean existsUsuarioByEmailContainingAndSenha(String email, String senha);

    // 1. findById ignorando status = EXCLUIDO
    Optional<Usuario> findByIdAndStatusNot(Long id, EnumStatusUsuario status );

    // 2. findAll ignorando status = EXCLUIDO
    List<Usuario> findAllByStatusNot(EnumStatusUsuario status);


}
