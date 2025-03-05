package br.ifba.inf011.main;
import br.ifba.inf011.model.Evento;
import br.ifba.inf011.notificador.Notificador;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        Notificador notificador = new Notificador();

        
        Evento eventoAlta = new Evento(10, "(Prioridade Urgente)", LocalDate.now(), LocalDateTime.now());
        notificador.notificar(eventoAlta);

        
        Evento eventoMedia = new Evento(6, "(Prioridade Normal)", LocalDate.now(), LocalDateTime.now());
        notificador.notificar(eventoMedia);

        
        Evento eventoBaixa = new Evento(3, "(Prioridade Baixa)", LocalDate.now(), LocalDateTime.now());
        notificador.notificar(eventoBaixa);
    }
}
