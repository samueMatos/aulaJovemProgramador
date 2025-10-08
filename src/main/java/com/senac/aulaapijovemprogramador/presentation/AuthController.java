package com.senac.aulaapijovemprogramador.presentation;


import com.senac.aulaapijovemprogramador.application.dto.auth.LoginRequestDto;
import com.senac.aulaapijovemprogramador.application.dto.auth.LoginResponseDto;
import com.senac.aulaapijovemprogramador.application.services.TokenService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@Tag(name = "Autenticação controller",description = "Gerenciamento de autenticações!")
public class AuthController {

    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    @Operation(summary = "Autenticação de usuário", description = "Método para fazer login do usuário!")
    public ResponseEntity<LoginResponseDto> login (@RequestBody LoginRequestDto login){

        if(login.email().equals("string") && login.senha().equals("string")) {

            var token = tokenService.gerarToken(login);
            if (token == null){
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
            }
            return  ResponseEntity.ok(new LoginResponseDto(token));
        }

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();

    }
}
