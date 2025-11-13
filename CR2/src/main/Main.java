package main;

import java.time.LocalDateTime;
import java.time.LocalDate;
import java.util.Arrays;

import model.Cupom;
import model.Pedido;
import model.IntervaloDesconto;

import service.AplicadorCupom;
import service.AplicadorDescontoIntervalo;

public class Main {
    public static void main(String[] args) {
        try {
            Pedido pedido = new Pedido(200.0, 20.0); // valorProdutos + taxaEntrega
            Pedido pedido2 = new Pedido(250.0, 0.0);
            Pedido pedido3 = new Pedido(300.0, 0.0);
            Pedido pedido4 = new Pedido(250.0, 10.0);

            // ====== CR1 (CUPONS) ======
            AplicadorCupom aplicadorCupom = new AplicadorCupom();

            Cupom black50 = new Cupom("BLACK50", 50,
                    LocalDateTime.of(2025, 11, 28, 0, 0),
                    LocalDateTime.of(2025, 11, 28, 23, 59));

            Cupom desc10 = new Cupom("DESC10", 10,
                    LocalDateTime.of(2025, 10, 25, 0, 0),
                    LocalDateTime.of(2025, 10, 27, 23, 59));

            Cupom desc20 = new Cupom("DESC20", 20,
                    LocalDateTime.of(2025, 11, 1, 0, 0),
                    LocalDateTime.of(2025, 11, 5, 23, 59));

            Cupom desc30 = new Cupom("DESC30", 30,
                    LocalDateTime.of(2025, 12, 24, 0, 0),
                    LocalDateTime.of(2025, 12, 24, 23, 59));

            Cupom daipai12 = new Cupom("daipai12", 12,
                    LocalDateTime.of(2025, 8, 9, 0, 0),
                    LocalDateTime.of(2025, 8, 10, 23, 59));

            Cupom daimae12 = new Cupom("daimae12", 12,
                    LocalDateTime.of(2025, 5, 10, 0, 0),
                    LocalDateTime.of(2025, 5, 12, 23, 59));

            Cupom natal10 = new Cupom("natal10", 10,
                    LocalDateTime.of(2025, 12, 20, 0, 0),
                    LocalDateTime.of(2025, 12, 26, 23, 59));

            Cupom festa15 = new Cupom("festa15", 15,
                    LocalDateTime.of(2025, 12, 30, 0, 0),
                    LocalDateTime.of(2026, 1, 1, 6, 0));

            // ====== CR2 (INTERVALOS) ======
            IntervaloDesconto aniversario = new IntervaloDesconto(
                    "Aniversário da Loja",
                    LocalDate.of(2025, 5, 22),
                    LocalDate.of(2025, 5, 27),
                    0.10
            );

            IntervaloDesconto semanaBlack = new IntervaloDesconto(
                    "Semana Black",
                    LocalDate.of(2025, 11, 12),
                    LocalDate.of(2025, 11, 30),
                    0.20
            );

            AplicadorDescontoIntervalo aplicadorIntervalo = new AplicadorDescontoIntervalo(
                    Arrays.asList(aniversario, semanaBlack),
                    true // política CR2 ativa
            );

            // ====== TESTE: APLICAR CUPOM (CR1) ======
            LocalDateTime agora = LocalDateTime.now();
            //aplicadorCupom.aplicar(pedido, festa15, agora);

            // ====== TESTE: APLICAR INTERVALO (CR2) ======
            LocalDate hoje = LocalDate.now();
            aplicadorIntervalo.aplicar(pedido2, hoje);

        } catch (Exception e) {
            System.out.println("❌ Erro ao aplicar desconto: " + e.getMessage());
            e.printStackTrace(); // opcional, útil para depuração
        }
    }
}
