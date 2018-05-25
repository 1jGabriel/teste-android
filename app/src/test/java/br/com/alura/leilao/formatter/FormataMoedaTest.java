package br.com.alura.leilao.formatter;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

public class FormataMoedaTest {

    @Test
    public void deveFormatarValoresParaMoedaBrasileira() {
        String moedaBrasileira = FormataMoeda.formata(200.0);
        assertThat(moedaBrasileira, equalTo("R$ 200,00"));
    }

}