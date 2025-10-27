package service;

import java.time.LocalDateTime;

import model.Cupom;
import model.Pedido;

public class AplicadorCupom {
    private ValidadorCupom validador;
    private LogAplicacaoCupom logger;

    public AplicadorCupom() {
        this.validador = new ValidadorCupom();
        this.logger = new LogAplicacaoCupom();
    }

    public void aplicar(Pedido pedido, Cupom cupom, LocalDateTime agora) {
        try {
            validador.validar(cupom, pedido, agora);
            pedido.aplicarCupom(cupom); // ✅ sem passar validador
            System.out.println("Cupom aplicado com sucesso: " + cupom.getCodigo());
            System.out.println("Valor final: R$ " + pedido.calcularValorFinal());
            System.out.println("|---|---|---|---|---|---|");

        } catch (Exception e) {
            logger.registrarTentativa(agora, cupom != null ? cupom.getCodigo() : "NULO", e.getMessage());
            //System.out.println("Falha ao aplicar cupom: " + e.getMessage());
            System.out.println("Valor final: R$ " + pedido.getValorTotalSemDesconto());
            System.out.println("|---|---|---|---|---|---|");

        }
    }
}
