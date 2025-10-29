package com.senac.aulaapijovemprogramador.presentation;

import com.senac.aulaapijovemprogramador.application.dto.usuario.UsuarioLogadoDto;
import com.senac.aulaapijovemprogramador.application.services.PedidoService;
import org.aspectj.weaver.ResolvedPointcutDefinition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticatedPrincipal;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("pedido")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @GetMapping
    public ResponseEntity<?> consultarPedidos(@AuthenticationPrincipal UsuarioLogadoDto usuario){

        var user = usuario.email();
        return ResponseEntity.ok(pedidoService.listarTodos());
    }
}
