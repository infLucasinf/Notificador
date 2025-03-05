package br.ifba.inf011.strategy;

import br.ifba.inf011.model.Evento;

public class NotificacaoSMS implements EstrategiaNotificacao {
    @Override
    public String formatarMensagem(Evento e) {
        return "SMS: Alerta - " + e.getDescricao();
    }

    @Override
    public void enviar(String mensagem) {
        System.out.println("Enviando via SMS: " + mensagem);
    }
}