/*package model;

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
}*/


package model;

public class Pedido {
    private double valorProdutos;
    private double taxaEntrega;
    private double valorTotalComDesconto;
    private Cupom cupomAplicado; // referência ao cupom aplicado
    private double descontoPercentual;
    private String nomeDesconto; // usado pela CR2 (intervalo de data)

    public Pedido(double valorProdutos, double taxaEntrega) {
        this.valorProdutos = valorProdutos;
        this.taxaEntrega = taxaEntrega;
        this.valorTotalComDesconto = valorProdutos + taxaEntrega;
    }

    public double getValorTotalSemDesconto() {
        return valorProdutos + taxaEntrega;
    }

    public double getValorTotalComDesconto() {
        return valorTotalComDesconto;
    }

    public void setValorTotalComDesconto(double valorTotalComDesconto) {
        this.valorTotalComDesconto = valorTotalComDesconto;
    }

    public Cupom getCupomAplicado() {
        return cupomAplicado;
    }

    public void setCupomAplicado(Cupom cupomAplicado) {
        this.cupomAplicado = cupomAplicado;
    }

    public double getDescontoPercentual() {
        return descontoPercentual;
    }

    public void setDescontoPercentual(double descontoPercentual) {
        this.descontoPercentual = descontoPercentual;
    }

    public String getNomeDesconto() {
        return nomeDesconto;
    }

    public void setNomeDesconto(String nomeDesconto) {
        this.nomeDesconto = nomeDesconto;
    }

    public double calcularValorFinal() {
        return valorTotalComDesconto;
    }

    // 🔹 MÉTODO NOVO: aplica o cupom e atualiza os valores
    public void aplicarCupom(Cupom cupom) {
        this.cupomAplicado = cupom;

        if (cupom != null) {
            double desconto = cupom.getPercentualDesconto() / 100.0;
            double valorSemDesconto = getValorTotalSemDesconto();
            this.valorTotalComDesconto = valorSemDesconto * (1 - desconto);
            this.descontoPercentual = cupom.getPercentualDesconto();
            this.nomeDesconto = "Cupom: " + cupom.getCodigo();
        } else {
            this.valorTotalComDesconto = getValorTotalSemDesconto();
            this.descontoPercentual = 0;
            this.nomeDesconto = "Sem desconto";
        }
    }
}

