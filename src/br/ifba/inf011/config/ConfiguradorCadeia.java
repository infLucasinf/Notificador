package br.ifba.inf011.config;

import java.util.Arrays;
import java.util.List;

import br.ifba.inf011.handler.Handler;
import br.ifba.inf011.handler.HandlerPrioridadeAlta;
import br.ifba.inf011.handler.HandlerPrioridadeBaixa;
import br.ifba.inf011.handler.HandlerPrioridadeMedia;
import br.ifba.inf011.strategy.EstrategiaNotificacao;
import br.ifba.inf011.strategy.NotificacaoEmail;
import br.ifba.inf011.strategy.NotificacaoRedeSocial;
import br.ifba.inf011.strategy.NotificacaoSMS;
import br.ifba.inf011.strategy.NotificacaoWhatsApp;

public class ConfiguradorCadeia {

    public static List<Handler> configurarCadeia() {
        EstrategiaNotificacao email = criarNotificacaoEmail();
        EstrategiaNotificacao whatsApp = criarNotificacaoWhatsApp();
        EstrategiaNotificacao sms = criarNotificacaoSMS();
        EstrategiaNotificacao redeSocial = criarNotificacaoRedeSocial();

        Handler alta = criarHandlerAlta(email, whatsApp, sms);
        Handler media = criarHandlerMedia(email, redeSocial);
        Handler baixa = criarHandlerBaixa(email);

        configurarCadeiaHandlers(alta, media, baixa);

        return Arrays.asList(alta);
    }

    private static EstrategiaNotificacao criarNotificacaoEmail() {
        return new NotificacaoEmail();
    }

    private static EstrategiaNotificacao criarNotificacaoWhatsApp() {
        return new NotificacaoWhatsApp();
    }

    private static EstrategiaNotificacao criarNotificacaoSMS() {
        return new NotificacaoSMS();
    }

    private static EstrategiaNotificacao criarNotificacaoRedeSocial() {
        return new NotificacaoRedeSocial();
    }

    private static Handler criarHandlerAlta(EstrategiaNotificacao email, EstrategiaNotificacao whatsApp, EstrategiaNotificacao sms) {
        return new HandlerPrioridadeAlta(email, whatsApp, sms);
    }

    private static Handler criarHandlerMedia(EstrategiaNotificacao email, EstrategiaNotificacao redeSocial) {
        return new HandlerPrioridadeMedia(email, redeSocial);
    }

    private static Handler criarHandlerBaixa(EstrategiaNotificacao email) {
        return new HandlerPrioridadeBaixa(email);
    }

    private static void configurarCadeiaHandlers(Handler alta, Handler media, Handler baixa) {
        alta.setProximo(media);
        media.setProximo(baixa);
    }
}