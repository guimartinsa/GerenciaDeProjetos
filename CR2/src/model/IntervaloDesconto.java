package model;

import java.time.LocalDate;

public class IntervaloDesconto {
    private String nome;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private double percentual;

    public IntervaloDesconto(String nome, LocalDate dataInicio, LocalDate dataFim, double percentual) throws Exception {
        if (nome == null || nome.trim().isEmpty()) {
            throw new Exception("Nome da ocasião não pode ser vazio.");
        }
        if (dataInicio == null || dataFim == null || dataInicio.isAfter(dataFim)) {
            throw new Exception("Intervalo de datas inválido.");
        }
        if (percentual <= 0 || percentual > 1) {
            throw new Exception("Percentual fora dos limites permitidos (0 < p ≤ 1).");
        }

        this.nome = nome;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.percentual = percentual;
    }

    public boolean estaNoIntervalo(LocalDate data) {
        return (data.isEqual(dataInicio) || data.isAfter(dataInicio)) &&
               (data.isEqual(dataFim) || data.isBefore(dataFim));
    }

    public String getNome() { return nome; }
    public LocalDate getDataInicio() { return dataInicio; }
    public LocalDate getDataFim() { return dataFim; }
    public double getPercentual() { return percentual; }
}
