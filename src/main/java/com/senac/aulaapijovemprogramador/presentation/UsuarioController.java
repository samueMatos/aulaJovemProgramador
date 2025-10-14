package com.senac.aulaapijovemprogramador.presentation;

import com.senac.aulaapijovemprogramador.application.dto.usuario.UsuarioCriarRequestDto;
import com.senac.aulaapijovemprogramador.application.dto.usuario.UsuarioResponseDto;
import com.senac.aulaapijovemprogramador.application.services.UsuarioService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
@Tag(name = "Usuarios controller",description = "Controladora responsavel por gerenciar os usuarios!")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;


    @GetMapping
    @Operation(summary = "Listar todos",description = "Método para listar todos os usuários!")
    public ResponseEntity<List<UsuarioResponseDto>> listarTodos() {
        return ResponseEntity.ok(usuarioService.listarTodos());
    }



    @GetMapping("/{id}")
    @Operation(summary = "Consulta de usuario por ID", description = "Médoto responsavel por consultar um unico usuario por ID e se não existir retorna null!")
    public ResponseEntity<?> buscarPorId(@PathVariable Long id){
        try {

            var usuario = usuarioService.buscarPorId(id);

            if(usuario == null){
                return ResponseEntity.notFound().build();
            }

            return  ResponseEntity.ok(usuario);

        }catch (IllegalArgumentException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PostMapping
    @Operation(summary = "Criar usuario",description = "Metodo resposavel por criar usuário")
    public ResponseEntity<?> criarUsuario(@RequestBody UsuarioCriarRequestDto usuario){

        try {
            var usuarioSalvo = usuarioService.salvarUsuario(usuario);
            return ResponseEntity.ok(usuarioSalvo);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


    @PutMapping("/{id}")
    @Operation(summary = "Atualizar usuario",description = "Metodo resposavel por atualizar usuário")
    public ResponseEntity<?> atulizarUsuario(@PathVariable Long id, @RequestBody UsuarioCriarRequestDto usuario){

        try {
            var usuarioSalvo = usuarioService.salvarUsuario(usuario);
            return ResponseEntity.ok(usuarioSalvo);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete de usuário!",description = "Método responsavel por deletar um usuario")
    public ResponseEntity<?> deletarUsuario(@PathVariable Long id){
        return usuarioService.excluirUsuario(id) ?
                ResponseEntity.ok().build() :
                ResponseEntity.notFound().build();
    }

    @PatchMapping("/{id}/bloquear")
    @Operation(summary = "Bloquear de usuário!",description = "Método responsavel por Bloquear um usuario")
    public ResponseEntity<?> atualizarBloquear(@PathVariable Long id){

        return usuarioService.bloquearUsuario(id) ?
                ResponseEntity.ok().build() :
                ResponseEntity.notFound().build();
    }



    @PatchMapping("/{id}/desbloquear")
    @Operation(summary = "Desbloquear de usuário!",description = "Método responsavel por Desbloquear um usuario")
    public ResponseEntity<?> atualizarDesbloquear(@PathVariable Long id){

        return usuarioService.desbloquearUsuario(id) ?
                ResponseEntity.ok().build() :
                ResponseEntity.notFound().build();
    }
}
