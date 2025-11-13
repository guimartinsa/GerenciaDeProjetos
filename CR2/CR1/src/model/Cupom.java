package model;

import java.time.LocalDateTime;

public class Cupom {
    private String codigo;
    private double percentualDesconto;
    private LocalDateTime inicioValidade;
    private LocalDateTime fimValidade;

    public Cupom(String codigo, double percentualDesconto, LocalDateTime inicioValidade, LocalDateTime fimValidade) {
        this.codigo = codigo;
        this.percentualDesconto = percentualDesconto;
        this.inicioValidade = inicioValidade;
        this.fimValidade = fimValidade;
    }

    public String getCodigo() {
        return codigo;
    }

    public double getPercentualDesconto() {
        return percentualDesconto;
    }

    public boolean isValido(LocalDateTime agora) {
        return !agora.isBefore(inicioValidade) && !agora.isAfter(fimValidade);
    }

    @Override
    public String toString() {
        return codigo + " (" + percentualDesconto + "%)";
    }
}
