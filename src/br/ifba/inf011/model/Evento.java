package br.ifba.inf011.model;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Evento {
    private int prioridade;
    private String descricao;
    private LocalDate data;
    private LocalDateTime dataHoraInicio;

    public Evento(int prioridade, String descricao, LocalDate data, LocalDateTime dataHoraInicio) {
        this.prioridade = prioridade;
        this.descricao = descricao;
        this.data = data;
        this.dataHoraInicio = dataHoraInicio;
    }

    public int getPrioridade() {
        return prioridade;
    }

    public String getDescricao() {
        return descricao;
    }

    public boolean iniciaEm(LocalDate dataReferencia) {
        return data != null && data.equals(dataReferencia);
    }

    
    public boolean iniciaEntre(LocalDateTime inicio, LocalDateTime fim) {
        return dataHoraInicio != null &&
               (dataHoraInicio.isAfter(inicio) || dataHoraInicio.equals(inicio)) &&
               (dataHoraInicio.isBefore(fim) || dataHoraInicio.equals(fim));
    }
}
