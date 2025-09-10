package com.senac.aulaapijovemprogramador.controllers;


import com.senac.aulaapijovemprogramador.dto.LoginRequestDto;
import com.senac.aulaapijovemprogramador.model.entities.Usuario;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@Tag(name = "Autenticação controller",description = "Gerenciamento de autenticações!")
public class AuthController {


    @PostMapping("/login")
    @Operation(summary = "Autenticação de usuário", description = "Método para fazer login do usuário!")
    public ResponseEntity<?> login (@RequestBody LoginRequestDto login){

        if(login.email().equals("string") && login.senha().equals("string")) {
            return  ResponseEntity.ok(login);
        }

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();

    }
}
