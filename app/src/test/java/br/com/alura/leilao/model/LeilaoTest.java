package br.com.alura.leilao.model;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import br.com.alura.leilao.builder.CriadorDeLeilao;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

public class LeilaoTest {

    public static final String PLAYSTATION_4 = "Playstation 4";
    private Usuario alex;
    private Usuario fran;


    @Before
    public void criaUsuario() {
        this.alex = new Usuario("Alex");
        this.fran = new Usuario("Fran");
    }

    @Test
    public void deveDevolverMaiorLance() {
        Leilao leilao = new CriadorDeLeilao(PLAYSTATION_4)
                .lance(new Lance(alex, 200.0))
                .lance(new Lance(fran, 350.0))
                .constroi();

        double maiorDeTodos = leilao.getMaiorDeTodos();

        assertThat(maiorDeTodos, equalTo(350.0));
    }

    @Test
    public void deveDevolverMenorLance() {
        Leilao leilao = new CriadorDeLeilao(PLAYSTATION_4)
                .lance(new Lance(alex, 200))
                .lance(new Lance(fran, 350))
                .constroi();

        double menorDeTodos = leilao.getMenorDeTodos();
        assertThat(menorDeTodos, equalTo(200.0));
    }

    @Test
    public void deveDevolverMaiorQuandoOsLancesSaoDadosEmOrdemDescrescente() {
        Leilao leilao = new CriadorDeLeilao(PLAYSTATION_4)
                .lance(new Lance(alex, 500.0))
                .lance(new Lance(fran, 400.0))
                .constroi();

        double maiorDeTodos = leilao.getMaiorDeTodos();
        assertThat(maiorDeTodos, equalTo(500.0));
    }

    @Test
    public void naoDeveDevolverMenorQuandoOsLancesSaoDadosEmOrdemDescrescente() {
        Leilao leilao = new CriadorDeLeilao(PLAYSTATION_4)
                .lance(new Lance(alex, 500.0))
                .lance(new Lance(fran, 400.0))
                .constroi();

        double menorDeTodos = leilao.getMenorDeTodos();
        assertThat(menorDeTodos, equalTo(500.0));
    }

    @Test
    public void deveAvaliarLeilaoComApenasUmLance() {
        Leilao leilao = new CriadorDeLeilao(PLAYSTATION_4)
                .lance(new Lance(alex, 500.0))
                .constroi();

        double menorDeTodos = leilao.getMenorDeTodos();
        assertThat(menorDeTodos, equalTo(500.0));

        double maiorDeTodos = leilao.getMaiorDeTodos();
        assertThat(maiorDeTodos, equalTo(500.0));
    }

    @Test
    public void deveDevolverTresMaioresLances() {
        Leilao leilao = new CriadorDeLeilao(PLAYSTATION_4)
                .lance(new Lance(alex, 2000.0))
                .lance(new Lance(fran, 3000.0))
                .lance(new Lance(alex, 5000.0))
                .lance(new Lance(fran, 6000.0))
                .constroi();

        List<Lance> tresMaiores = leilao.tresMaiores();
        assertThat(tresMaiores.size(), equalTo(3));

        assertThat(tresMaiores.get(0).getValor(), equalTo(6000.0));
        assertThat(tresMaiores.get(1).getValor(), equalTo(5000.0));
        assertThat(tresMaiores.get(2).getValor(), equalTo(3000.0));
    }

    @Test
    public void naoDeveAceitarDoisLancesSeguidosDoMesmoUsuario() {
        Leilao leilao = new CriadorDeLeilao(PLAYSTATION_4)
                .lance(new Lance(alex, 200.0))
                .lance(new Lance(alex, 300.0))
                .constroi();

        assertThat(leilao.getLances().size(), equalTo(1));

        Lance lance = leilao.getLances().get(0);
        assertThat(lance.getValor(), equalTo(200.0));

        leilao.propoe(new Lance(fran, 400.0));
        leilao.propoe(new Lance(alex, 500.0));
        leilao.propoe(new Lance(alex, 600.0));

        assertThat(leilao.getLances().size(), equalTo(3));
        assertThat(leilao.getLances().get(0).getValor(), equalTo(500.0));
        assertThat(leilao.getLances().get(1).getValor(), equalTo(400.0));
    }

}