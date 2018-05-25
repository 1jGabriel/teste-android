package br.com.alura.leilao.ui.recyclerview.adapter;

import android.content.Context;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.com.alura.leilao.builder.CriadorDeLeilao;
import br.com.alura.leilao.model.Lance;
import br.com.alura.leilao.model.Leilao;
import br.com.alura.leilao.model.Usuario;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;


public class ListaLeilaoAdapterTest {

    @Mock
    Context context;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void deveAdicionarLeiloes() {
        ListaLeilaoAdapter adapter = new ListaLeilaoAdapter(context);
        adapter.adiciona(leiloesDeExemplo());
        int quantidadeLeiloes = adapter.getItemCount();
        assertThat(quantidadeLeiloes, equalTo(quantidadeLeiloes));
    }

    public List<Leilao> leiloesDeExemplo() {
        List<Leilao> leiloes = new ArrayList<>();
        Leilao leilao = new CriadorDeLeilao("Playstation 4")
                .lance(new Lance(new Usuario("Alex"), 200.0))
                .constroi();
        leiloes.addAll(Arrays.asList(leilao));
        return leiloes;
    }

}