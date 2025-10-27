package service;

import java.time.LocalDateTime;

import model.Cupom;
import model.Pedido;

public class ValidadorCupom {

    public void validar(Cupom cupom, Pedido pedido, LocalDateTime agora) throws Exception {
        if (cupom == null || cupom.getCodigo() == null || cupom.getCodigo().trim().isEmpty()) {
            throw new Exception("Nenhum cupom informado.");
        }

        if (!cupom.isValido(agora)) {
            throw new Exception("Cupom fora do período de validade.");
        }

        Cupom cupomAtual = pedido.getCupomAplicado();
        if (cupomAtual != null && cupom.getPercentualDesconto() >= cupomAtual.getPercentualDesconto()) {
            throw new Exception ("Novo Cupom aplicado com sucesso!");
        }
        if (cupomAtual != null && cupom.getPercentualDesconto() <= cupomAtual.getPercentualDesconto()) {
            throw new Exception("Cupom possui desconto menor ou igual ao já aplicado.");
        }
    }
}
