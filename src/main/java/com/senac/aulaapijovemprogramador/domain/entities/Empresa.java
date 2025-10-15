package com.senac.aulaapijovemprogramador.domain.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String CNPJ;

    private String nomeFantasia;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "empresa_id")
    private List<Pedido> pedidos;

}
