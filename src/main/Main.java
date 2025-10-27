package main;

import java.time.LocalDateTime;

import model.Cupom;
import model.Pedido;
import service.AplicadorCupom;

public class Main {
        static void main(String[] args) {
                Pedido pedido = new Pedido(200.0, 20.0); // valorProdutos + taxaEntrega
                Pedido pedido2 = new Pedido(250.0, 0.0); // valorProdutos + taxaEntrega
                Pedido pedido3 = new Pedido(300.0, 0.0);
                AplicadorCupom aplicador = new AplicadorCupom();

                Cupom black50 = new Cupom("BLACK50", 50,
                        LocalDateTime.of(2025, 11, 28, 0, 0), //inicio da validade
                        LocalDateTime.of(2025, 11, 28, 23, 59)); //fim da validade

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

            Cupom festa10 = new Cupom("festa10", 20,
                    LocalDateTime.of(2025, 12, 30, 0, 0),
                    LocalDateTime.of(2026, 1, 1, 6, 0));


                LocalDateTime agora = LocalDateTime.of(2026, 1, 1, 6, 0);
                //LocalDateTime agora = LocalDateTime.now();


                aplicador.aplicar(pedido, festa15, agora);
                aplicador.aplicar(pedido, festa10, agora);

            //System.out.println("Valor final: R$ " + pedido.calcularValorFinal());

        }
}
