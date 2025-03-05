package br.ifba.inf011.handler;
import br.ifba.inf011.model.Evento;

public abstract class Handler {
    private Handler proximo;

    public void setProximo(Handler proximo) {
        this.proximo = proximo;
    }

    public void processar(Evento e) {
        if (podeProcessar(e)) {
            notificar(e);
        } else if (proximo != null) {
            proximo.processar(e);
        } else {
            System.out.println("Nenhum notificação disponível para processar o evento: " + e.getDescricao());
        }
    }

    protected abstract boolean podeProcessar(Evento e);
    protected abstract void notificar(Evento e);
}
