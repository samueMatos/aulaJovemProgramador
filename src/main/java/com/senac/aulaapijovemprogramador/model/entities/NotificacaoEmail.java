package com.senac.aulaapijovemprogramador.model.entities;

import com.senac.aulaapijovemprogramador.model.interfaces.INotificacao;

public class NotificacaoEmail implements INotificacao {

    private String emailDestino;


    public NotificacaoEmail(String emailDestino){
        this.emailDestino = emailDestino;
    }

    @Override
    public void Enviar(String mensagem) {
        System.out.println("EMAIL PARA: "+this.emailDestino+" MENSAGEM: " + mensagem);
    }
}
