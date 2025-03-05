package br.ifba.inf011.strategy;
import br.ifba.inf011.model.Evento;

public class NotificacaoWhatsApp implements EstrategiaNotificacao {
    @Override
    public String formatarMensagem(Evento e) {        
        return "WhatsApp: Evento URGENTE - " + e.getDescricao();
    }

    @Override
    public void enviar(String mensagem) {
        System.out.println("Enviando via WhatsApp: " + mensagem);
    }
}
