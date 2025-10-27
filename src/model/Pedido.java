package model;

import java.time.LocalDateTime;

public class Pedido {
    private double valorProdutos;
    private double taxaEntrega;
    private Cupom cupomAplicado;

    public Pedido(double valorProdutos, double taxaEntrega) {
        this.valorProdutos = valorProdutos;
        this.taxaEntrega = taxaEntrega;
    }

    public double getValorTotalSemDesconto() {
        return valorProdutos + taxaEntrega;
    }

    public double calcularValorFinal() {
        if (cupomAplicado != null) {
            return (valorProdutos + taxaEntrega) * (1 - cupomAplicado.getPercentualDesconto() / 100);
        }
        return valorProdutos + taxaEntrega;
    }

    public void aplicarCupom(Cupom cupom) {
        this.cupomAplicado = cupom;
    }

    public Cupom getCupomAplicado() {
        return cupomAplicado;
    }
}
