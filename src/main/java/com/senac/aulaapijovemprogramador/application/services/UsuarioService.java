package com.senac.aulaapijovemprogramador.application.services;

import com.senac.aulaapijovemprogramador.application.dto.usuario.UsuarioCriarRequestDto;
import com.senac.aulaapijovemprogramador.application.dto.usuario.UsuarioResponseDto;
import com.senac.aulaapijovemprogramador.domain.entities.Administrador;
import com.senac.aulaapijovemprogramador.domain.entities.Usuario;
import com.senac.aulaapijovemprogramador.domain.repository.UsuarioRepository;
import com.senac.aulaapijovemprogramador.domain.valueobjects.EnumStatusUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<UsuarioResponseDto> listarTodos(){

        try {
            return  usuarioRepository
                    .findAllByStatusNot(EnumStatusUsuario.EXCLUIDO)
                    .stream()
                    .map(UsuarioResponseDto::new)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public UsuarioResponseDto buscarPorId(Long id){


        var usuarioBanco =usuarioRepository.findByIdAndStatusNot(id, EnumStatusUsuario.EXCLUIDO);
        return usuarioBanco
                .stream()
                .map(UsuarioResponseDto::new)
                .findFirst()
                .orElse(null);
    }


    public UsuarioResponseDto salvarUsuario(UsuarioCriarRequestDto usuarioRequest) throws Exception {
        var usuarioBanco = usuarioRepository
                .findByCpf_CpfAndStatusNot(usuarioRequest.cpf(),
                        EnumStatusUsuario.EXCLUIDO)
                .orElse(null);

        if(usuarioBanco == null){
            if(usuarioRequest.isAdm()){
                usuarioBanco = new Administrador(usuarioRequest);
            }else {
                usuarioBanco = new Usuario(usuarioRequest);
            }
        }

        if(usuarioBanco.getId() != null){
            usuarioBanco = usuarioBanco
                    .atulizarUsuarioFromDTO(usuarioBanco, usuarioRequest);
        }

        usuarioRepository.save(usuarioBanco);
        return new UsuarioResponseDto(usuarioBanco);
    }


    public boolean excluirUsuario(Long id){
       try{
            var usuario = usuarioRepository.findById(id).orElse(null);

            if(usuario == null){
                return false;
            }

           alterarStatusUsuario(usuario,EnumStatusUsuario.EXCLUIDO);

            return true;
       }catch (Exception e){
           System.out.print("Erro ao excluir usuaria!");
           return false;
       }
    }

    public boolean bloquearUsuario(Long id){

        try {

            var usuario = usuarioRepository.findByIdAndStatusNot(id,EnumStatusUsuario.EXCLUIDO).orElse(null);

            if(usuario == null){
                return false;
            }

            alterarStatusUsuario(usuario,EnumStatusUsuario.BLOQUEADO);

            return true;
        }catch (Exception e){
            System.out.println("Erro ao bloquear usuario!");
            return false;
        }
    }


    public boolean desbloquearUsuario(Long id){

        try {

            var usuario = usuarioRepository.findByIdAndStatusNot(id,EnumStatusUsuario.EXCLUIDO).orElse(null);

            if(usuario == null){
                return false;
            }

            alterarStatusUsuario(usuario,EnumStatusUsuario.ATIVO);
            return true;
        }catch (Exception e){
            System.out.println("Erro ao bloquear usuario!");
            return false;
        }
    }

    private void alterarStatusUsuario(Usuario usuario, EnumStatusUsuario statusUsuario){
        usuario.setStatus(statusUsuario);
        usuarioRepository.save(usuario);
    }
}
