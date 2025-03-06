FBA – Instituto Federal de Educação, Ciência e Tecnologia da Bahia <br>
Departamento de Ciência da Computação <br>
Graduação Tecnológica em Análise e Desenvolvimento de Sistemas <br>
INF011 – Padrões de Projeto <br>
Prof.: Frederico Barboza Data: 06/03/2025 <br>
Alunos: Lucas da Silva Fonseca e Jaqueline Gabriela <br>

# Padrões de Projeto Utilizados
## Chain of Responsibility
- **Propósito:** Permite que uma solicitação seja processada por uma cadeia de objetos (manipuladores), onde cada manipulador decide se pode tratá-la ou delegá-la ao próximo na cadeia.
- **Aplicação no Projeto:**
  - Handlers como `HandlerPrioridadeAlta`, `HandlerPrioridadeMedia` e `HandlerPrioridadeBaixa` processam eventos com base em faixas de prioridade e dados.
  - A classe `Notificador` configura a cadeia, que avalia cada evento em sequência até encontrar o manipulador correto.

## Strategy
- **Propósito:** Encapsula algoritmos em classes separadas, permitindo que o comportamento seja alterado dinamicamente.
- **Aplicação no Projeto:**
  - A interface `EstrategiaNotificacao` define os métodos para formatação e envio de notificações.
  - Implementações como `NotificacaoEmail` e `NotificacaoWhatsApp` fornecem lógicas específicas para envio de e-mails e mensagens via WhatsApp.

# Estrutura do Código

## Pacotes e Classes

O código está organizado nos seguintes pacotes e suas respectivas classes:

### `br.ifba.inf011.modelo`
- **`Evento.java`:** Classe que representa um evento, contendo prioridade, descrição e dados.

### `br.ifba.inf011.strategy`
- **`EstrategiaNotificacao.java`:** Interface para estratégias de notificação.
- **`NotificacaoEmail.java`:** Implementação para envio por e-mail.
- **`NotificacaoWhatsApp.java`:** Implementação para envio por WhatsApp.

### `br.ifba.inf011.service`
- **`CalendarService.java`:** Serviço responsável por adicionar eventos ao Google Calendar.

### `br.ifba.inf011.handler`
- **`Handler.java`:** Classe abstrata que define a estrutura da cadeia de manipuladores.
- **`HandlerPrioridadeAlta.java`:** Manipulador para eventos de alta prioridade.
- **`HandlerPrioridadeMedia.java`:** Manipulador para eventos de prioridade média.
- **`HandlerPrioridadeBaixa.java`:** Manipulador para eventos de baixa prioridade.

### `br.ifba.inf011.config`
- **`ConfiguradorCadeia.java`:** Classe que configura dinamicamente a cadeia de manipuladores e estratégias associadas.

### `br.ifba.inf011.notificador`
- **`Notificador.java`:** Classe principal que utiliza uma cadeia de manipuladores para processar eventos.

### `br.ifba.inf011.main`
- **`Main.java`:** Classe principal para apresentar o uso do sistema.