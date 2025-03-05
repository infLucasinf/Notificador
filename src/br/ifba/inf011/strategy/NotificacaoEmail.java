package br.ifba.inf011.strategy;
import br.ifba.inf011.model.Evento;

public class NotificacaoEmail implements EstrategiaNotificacao {
    @Override
    public String formatarMensagem(Evento e) {        
        return "Email: Evento Importante - " + e.getDescricao();
    }

    @Override
    public void enviar(String mensagem) {
        System.out.println("Enviando via Email: " + mensagem);
    }
}
