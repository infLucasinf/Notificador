package br.ifba.inf011.strategy;

import br.ifba.inf011.model.Evento;

public class NotificacaoRedeSocial implements EstrategiaNotificacao {
    @Override
    public String formatarMensagem(Evento e) {
        return "Rede Social: Novo evento - " + e.getDescricao();
    }

    @Override
    public void enviar(String mensagem) {
        System.out.println("Postando na rede social: " + mensagem);
    }
}