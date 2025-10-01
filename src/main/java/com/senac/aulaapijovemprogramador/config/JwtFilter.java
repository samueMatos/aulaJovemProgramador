package com.senac.aulaapijovemprogramador.config;

import com.senac.aulaapijovemprogramador.services.TokenService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtFilter extends OncePerRequestFilter {

    @Autowired
    private TokenService tokenService;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain)
            throws ServletException, IOException {


        String path = request.getRequestURI();

        if(path.equals("/auth/login")
        || path.equals("/usuario/cadastrese")
        ||path.startsWith("/swagger")
        ||path.startsWith("/v3/api-docs")
        ||path.startsWith("/webjars")){

            filterChain.doFilter(request,response);
            return;

        }

        String header = request.getHeader("Authorization");

        if (header !=null && header.startsWith("Bearer ")){
            String token = header.replace("Bearer ","");
            try {


                var jwt = tokenService.validarToken(token);

                var usuario = tokenService.consultarUsuarioPorToken(token);

                System.out.println("Usuario logado "+ usuario.getCpf() + jwt.getSubject());

            }catch (Exception e){
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                response.getWriter().write("Token inválido ou expirado!");
                return;
            }

        }else {
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            response.getWriter().write("Token não informado!");
            return;
        }

        filterChain.doFilter(request, response);

    }
}
