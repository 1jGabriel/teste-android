package br.com.alura.leilao.ui.activity;

import android.content.Intent;
import android.widget.TextView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;

import br.com.alura.leilao.R;
import br.com.alura.leilao.builder.CriadorDeLeilao;
import br.com.alura.leilao.formatter.FormataMoeda;
import br.com.alura.leilao.model.Lance;
import br.com.alura.leilao.model.Leilao;
import br.com.alura.leilao.model.Usuario;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

@RunWith(RobolectricTestRunner.class)
public class LancesLeilaoActivityTest {

    private Leilao leilao;
    private LancesLeilaoActivity activity;

    @Before
    public void criaLeilaoDeExemplo() {
        leilao = new CriadorDeLeilao("Playstation 4")
                .lance(new Lance(new Usuario("Alex"), 200.0))
                .lance(new Lance(new Usuario("Fran"), 300.0))
                .lance(new Lance(new Usuario("João"), 400.0))
                .lance(new Lance(new Usuario("Alex"), 550.0))
                .constroi();
    }

    @Before
    public void enviaLeilao() {
        activity = Robolectric.buildActivity(
                LancesLeilaoActivity.class,
                new Intent().putExtra("leilao", leilao))
                .create().get();
    }

    @Test
    public void deveApresentarDescricao() {
        TextView descricao = activity.findViewById(R.id.lances_leilao_descricao);
        assertThat(descricao.getText().toString(), equalTo("Playstation 4"));
    }

    @Test
    public void deveApresentarMaiorLance() {
        TextView maiorLance = activity.findViewById(R.id.lances_leilao_maior_lance);
        assertThat(maiorLance.getText().toString(), equalTo(FormataMoeda.formata(550.0)));
    }

    @Test
    public void deveApresentarMenorLance() {
        TextView menorLance = activity.findViewById(R.id.lances_leilao_menor_lance);
        assertThat(menorLance.getText().toString(), equalTo(FormataMoeda.formata(200.0)));
    }

    @Test
    public void deveApresentarTresMaioresLances() {
        TextView tresMaioresLances = activity.findViewById(R.id.lances_leilao_maiores_lances);
        assertThat(tresMaioresLances.getText().toString(), equalTo(
                FormataMoeda.formata(550.0) + "\n" +
                        FormataMoeda.formata(400.0) + "\n" +
                        FormataMoeda.formata(300.0) + "\n"));
    }

}