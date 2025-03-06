package br.ifba.inf011.handler;
import br.ifba.inf011.model.Evento;
import br.ifba.inf011.service.CalendarService;
import br.ifba.inf011.strategy.EstrategiaNotificacao;
import java.time.LocalDate;

public class HandlerPrioridadeAlta extends Handler {
	private CalendarService calendarService;
    private EstrategiaNotificacao estrategiaEmail;
    private EstrategiaNotificacao estrategiaWhatsApp;
    private EstrategiaNotificacao estrategiaSMS;

    public HandlerPrioridadeAlta(EstrategiaNotificacao estrategiaEmail, EstrategiaNotificacao estrategiaWhatsApp,EstrategiaNotificacao estrategiaSMS) {
        this.calendarService = new CalendarService();
        this.estrategiaEmail = estrategiaEmail;
        this.estrategiaWhatsApp = estrategiaWhatsApp;
        this.estrategiaSMS = estrategiaSMS;
    }

    @Override
    protected boolean podeProcessar(Evento e) {
        return e.getPrioridade() ==10 && e.iniciaEm(LocalDate.now());
    }

    @Override
    protected void notificar(Evento e) {
    	System.out.println("EVENTO DE PRIORIDADE ALTA"); 
        String mensagemEmail = estrategiaEmail.formatarMensagem(e);
        String mensagemWhatsApp = estrategiaWhatsApp.formatarMensagem(e);
        String mensagemSMS = estrategiaSMS.formatarMensagem(e);
        calendarService.adicionarEvento(mensagemWhatsApp);
        estrategiaEmail.enviar(mensagemEmail);
        estrategiaWhatsApp.enviar(mensagemWhatsApp);
        estrategiaSMS.enviar(mensagemSMS);
        
    }
}
