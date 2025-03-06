package br.ifba.inf011.handler;
import br.ifba.inf011.model.Evento;
import br.ifba.inf011.strategy.EstrategiaNotificacao;
import java.time.LocalDate;

public class HandlerPrioridadeMedia extends Handler {
    private EstrategiaNotificacao estrategiaEmail;
    private EstrategiaNotificacao estrategiaRedeSocial;

    public HandlerPrioridadeMedia(EstrategiaNotificacao estrategiaEmail,EstrategiaNotificacao estrategiaRedeSocial) {
        this.estrategiaEmail = estrategiaEmail;
        this.estrategiaRedeSocial = estrategiaRedeSocial;
    }

    @Override
    protected boolean podeProcessar(Evento e) {
       return e.getPrioridade() >= 5 && e.getPrioridade() < 10 && e.iniciaEm(LocalDate.now());
    }

    @Override
    protected void notificar(Evento e) {        
    	System.out.println("\nEVENTO DE PRIORIDADE NORMAL"); 
    	String mensagemEmail = estrategiaEmail.formatarMensagem(e);
        String mensagemRedeSocial = estrategiaRedeSocial.formatarMensagem(e);
        estrategiaEmail.enviar(mensagemEmail);
        estrategiaRedeSocial.enviar(mensagemRedeSocial);
    }
}
