package br.ifba.inf011.notificador;
import br.ifba.inf011.config.ConfiguradorCadeia;
import br.ifba.inf011.handler.Handler;
import br.ifba.inf011.model.Evento;

public class Notificador {
    private Handler cadeia;

    public Notificador() {
        
        this.cadeia = ConfiguradorCadeia.configurarCadeia().get(0); 
    }

    public void notificar(Evento e) {
        this.cadeia.processar(e);
    }
}
