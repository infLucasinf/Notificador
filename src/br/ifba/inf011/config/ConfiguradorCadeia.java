package br.ifba.inf011.config;

import br.ifba.inf011.handler.*;
import br.ifba.inf011.strategy.*;

import java.util.ArrayList;
import java.util.List;

public class ConfiguradorCadeia {
    
    public static List<Handler> configurarCadeia() {
        List<Handler> handlers = new ArrayList<>();

        
        EstrategiaNotificacao email = new NotificacaoEmail();
        EstrategiaNotificacao whatsApp = new NotificacaoWhatsApp();
        EstrategiaNotificacao sms = new NotificacaoSMS();
        EstrategiaNotificacao redeSocial = new NotificacaoRedeSocial();

        
        Handler alta = new HandlerPrioridadeAlta(email, whatsApp, sms);
        Handler media = new HandlerPrioridadeMedia(email, redeSocial);
        Handler baixa = new HandlerPrioridadeBaixa(email); 

        
        alta.setProximo(media);
        media.setProximo(baixa);

        handlers.add(alta);
        return handlers;
    }
}
