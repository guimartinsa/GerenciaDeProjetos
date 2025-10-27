package service;

import java.time.LocalDateTime;

public class LogAplicacaoCupom {

    public void registrarTentativa(LocalDateTime dataHora, String codigoCupom, String motivo) {
        System.out.println("Tentativa de aplicação de cupom rejeitada:");
        System.out.println("Data/Hora: " + dataHora);
        System.out.println("Código: " + codigoCupom);
        System.out.println("Motivo: " + motivo);
    }
}
