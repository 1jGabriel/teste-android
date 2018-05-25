package br.com.alura.leilao.formatter;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class FormataMoeda {

    public static String formata(double valor) {
        NumberFormat moedaBrasileira = DecimalFormat
                .getCurrencyInstance(new Locale("pt", "br"));
        return moedaBrasileira.format(valor);
    }

}
