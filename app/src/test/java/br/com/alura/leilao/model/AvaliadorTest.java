package br.com.alura.leilao.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class AvaliadorTest {

    @Test
    public void deveEntenderLancesEmOrdemCrescente() {
        Usuario alex = new Usuario("Alex");
        Usuario fran = new Usuario("Fran");
        Usuario joao = new Usuario("João");

        Leilao leilao = new Leilao("Playstion 4 novo");

        leilao.propoe(new Lance(alex, 100));
        leilao.propoe(new Lance(fran, 200));
        leilao.propoe(new Lance(joao, 350));

        Avaliador avaliador = new Avaliador();
        avaliador.avalia(leilao);

        Double menorDeTodos = avaliador.getMenorDeTodos();
        Double maiorDeTodos = avaliador.getMaiorDeTodos();
        assertEquals(100.0, menorDeTodos, 0.00001);
        assertEquals(350, maiorDeTodos, 0.00001);
    }
}