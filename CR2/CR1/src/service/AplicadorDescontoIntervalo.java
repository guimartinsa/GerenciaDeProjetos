package service;

import model.IntervaloDesconto;
import model.Pedido;

import java.time.LocalDate;
import java.util.List;

public class AplicadorDescontoIntervalo {
    private List<IntervaloDesconto> intervalos;
    private boolean politicaAtiva; // indica se CR2 está ativo no momento

    public AplicadorDescontoIntervalo(List<IntervaloDesconto> intervalos, boolean politicaAtiva) {
        this.intervalos = intervalos;
        this.politicaAtiva = politicaAtiva;
    }

    public void aplicar(Pedido pedido, LocalDate dataPedido) throws Exception {
        if (!politicaAtiva) {
            throw new Exception("Política de desconto por intervalo (CR2) não está ativa.");
        }

        IntervaloDesconto intervaloElegivel = null;

        for (IntervaloDesconto intervalo : intervalos) {
            if (intervalo.estaNoIntervalo(dataPedido)) {
                intervaloElegivel = intervalo;
                break;
            }
        }

        if (intervaloElegivel == null) {
            System.out.println("Nenhum intervalo ativo para a data do pedido.");
            return;
        }

        double percentual = intervaloElegivel.getPercentual();
        double valorOriginal = pedido.getValorTotalSemDesconto();
        double valorComDesconto = valorOriginal * (1 - percentual);

        pedido.setValorTotalComDesconto(valorComDesconto);
        pedido.setDescontoPercentual(percentual);
        pedido.setNomeDesconto(intervaloElegivel.getNome());

        System.out.println("Desconto aplicado: " + intervaloElegivel.getNome() +
                " (" + (percentual * 100) + "%)");
        System.out.println("Valor final: R$ " + valorComDesconto);
    }
}
