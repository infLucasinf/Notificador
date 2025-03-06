package br.ifba.inf011.handler;
import br.ifba.inf011.model.Evento;
import br.ifba.inf011.service.CalendarService;
import br.ifba.inf011.strategy.EstrategiaNotificacao;
import java.time.LocalDateTime;

public class HandlerPrioridadeBaixa extends Handler {
    private CalendarService calendarService;
    private EstrategiaNotificacao estrategiaEmail;

    public HandlerPrioridadeBaixa(EstrategiaNotificacao estrategiaEmail) {
        this.calendarService = new CalendarService();
        this.estrategiaEmail = estrategiaEmail;
    }

    @Override
    protected boolean podeProcessar(Evento e) {        
        return e.getPrioridade() >= 1 && e.getPrioridade() < 5 &&
               e.iniciaEntre(LocalDateTime.now().minusDays(2), LocalDateTime.now());
    }

    @Override
    protected void notificar(Evento e) {        
    	 System.out.println("\nEVENTO DE PRIORIDADE BAIXA");    	     	 
        String mensagem = estrategiaEmail.formatarMensagem(e);
        calendarService.adicionarEvento(mensagem);
    }
}
