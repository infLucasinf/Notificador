package br.ifba.inf011.strategy;
import br.ifba.inf011.model.Evento;

public interface EstrategiaNotificacao {    
    String formatarMensagem(Evento e);
    void enviar(String mensagem);
}
