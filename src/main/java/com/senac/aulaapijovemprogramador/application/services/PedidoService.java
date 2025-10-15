package com.senac.aulaapijovemprogramador.application.services;

import com.senac.aulaapijovemprogramador.application.dto.pedido.PedidoResponseDto;
import com.senac.aulaapijovemprogramador.application.dto.usuario.UsuarioResponseDto;
import com.senac.aulaapijovemprogramador.domain.repository.PedidoRepository;
import com.senac.aulaapijovemprogramador.domain.valueobjects.EnumStatusUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    public List<PedidoResponseDto> listarTodos() {

        return  pedidoRepository
                .findAll()
                .stream()
                .map(PedidoResponseDto::new)
                .collect(Collectors.toList());
    }
}
