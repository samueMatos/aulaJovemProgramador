package com.senac.aulaapijovemprogramador.services;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.senac.aulaapijovemprogramador.dto.LoginRequestDto;
import com.senac.aulaapijovemprogramador.model.entities.Token;
import com.senac.aulaapijovemprogramador.model.entities.Usuario;
import com.senac.aulaapijovemprogramador.model.repository.TokenRepository;
import com.senac.aulaapijovemprogramador.model.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Base64;

@Service
public class TokenService {
    @Autowired
    private TokenRepository tokenRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Value("${spring.minhapalavrafoda}")
    private String secret;

    private String emissor = "Samuel";

    @Value("${spring.sessao}")
    private Long tempo;

    public String gerarToken(LoginRequestDto login){
       try {
           Algorithm algorithm = Algorithm.HMAC256(secret);
           var usuario = usuarioRepository.findByEmail(login.email())
                   .orElseThrow(()-> new Exception("Usuário não encontrado!"));

           var dataExpiracao = this.gerarDataExpiracao();

           String token = JWT.create()
                   .withIssuer(emissor)
                   .withSubject(login.email())
                   .withExpiresAt(dataExpiracao.plusHours(15)
                           .toInstant(ZoneOffset.of("-03:00")))
                   .sign(algorithm);

           this.salvarToken(token,dataExpiracao,usuario);

            return token;

       } catch (Exception e) {
           return null;
       }
    }

    public Usuario consultarUsuarioPorToken(String token) throws Exception {
       var tokenBanco = tokenRepository.findByToken(token)
               .orElseThrow(()-> new  Exception("Token não encontrado!"));

       if(tokenBanco.getDataExpiracao().isBefore(LocalDateTime.now())){
            throw new Exception("Token expirado!");
       }

       tokenBanco.setDataExpiracao(LocalDateTime.now().plusMinutes(tempo));
       tokenRepository.save(tokenBanco);

       return tokenBanco.getUsuario();
    }

    public void salvarToken(String token, LocalDateTime dataExpiracaos, Usuario usuario){

        var tokenBanco = new Token();

        tokenBanco.setToken(token);
        tokenBanco.setDataExpiracao(dataExpiracaos);
        tokenBanco.setUsuario(usuario);

        tokenRepository.save(tokenBanco);
    }


    public DecodedJWT validarToken(String token){
        Algorithm algorithm = Algorithm.HMAC256(secret);

        JWTVerifier verifier = JWT.require(algorithm)
                .withIssuer(emissor)
                .build();

        return verifier.verify(token);
    }


    private LocalDateTime gerarDataExpiracao(){
        var dataAtual = LocalDateTime.now();
        return dataAtual.plusMinutes(tempo);
    }


}
