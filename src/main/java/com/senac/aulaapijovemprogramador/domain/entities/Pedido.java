package com.senac.aulaapijovemprogramador.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descricao;
    private double valor;
    private String status;
    private double custo;

    @ManyToOne
    @JoinColumn(name = "empresa_id")
    private Empresa empresa;


    @OneToOne
    @JoinColumn(name = "nota_id")
    private NotaFiscal notaFiscal;


    public double cacularLucro(){
        return this.valor - this.custo;
    }

}
