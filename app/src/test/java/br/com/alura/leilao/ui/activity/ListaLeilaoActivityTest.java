package br.com.alura.leilao.ui.activity;

import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;

import java.util.ArrayList;
import java.util.List;

import br.com.alura.leilao.R;
import br.com.alura.leilao.formatter.FormataMoeda;
import br.com.alura.leilao.model.Lance;
import br.com.alura.leilao.model.Leilao;
import br.com.alura.leilao.model.Usuario;
import br.com.alura.leilao.ui.recyclerview.adapter.ListaLeilaoAdapter;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

@RunWith(RobolectricTestRunner.class)
public class ListaLeilaoActivityTest {

    @Test
    public void deveAparecerLeiloesComDescricaoEMaiorLance() {
        ListaLeilaoActivity activity = Robolectric.setupActivity(ListaLeilaoActivity.class);
        RecyclerView recyclerView = activity.findViewById(R.id.lista_leilao_recyclerview);

        ListaLeilaoAdapter adapter = new ListaLeilaoAdapter(activity);
        adapter.adiciona(leiloesDeExemplo());
        recyclerView.setAdapter(adapter);

        RecyclerView.Adapter adapterConfigurado = recyclerView.getAdapter();
        assertThat(adapterConfigurado.getItemCount(), equalTo(3));

        RecyclerView.ViewHolder viewHolder = recyclerView.findViewHolderForAdapterPosition(0);
        TextView descricao = viewHolder.itemView.findViewById(R.id.item_leilao_descricao);
        TextView maiorLance = viewHolder.itemView.findViewById(R.id.item_leilao_maior_lance);

        assertThat(descricao.getText().toString(), equalTo("Videogame novo"));
        assertThat(maiorLance.getText().toString(), equalTo(FormataMoeda.formata(500)));
    }

    private List<Leilao> leiloesDeExemplo() {
        List<Leilao> leiloes = new ArrayList<>();
        Usuario alex = new Usuario("Alex");
        Usuario joao = new Usuario("João");
        Usuario fran = new Usuario("Fran");

        Leilao videogameNovo = new Leilao("Videogame novo");
        videogameNovo.propoe(new Lance(alex, 100));
        videogameNovo.propoe(new Lance(joao, 150));
        videogameNovo.propoe(new Lance(fran, 400));
        videogameNovo.propoe(new Lance(alex, 500));

        Leilao computadorUsado = new Leilao("Computador usado");
        computadorUsado.propoe(new Lance(joao, 200));
        computadorUsado.propoe(new Lance(alex, 300));

        Leilao carroUsado = new Leilao("Carro usado");
        carroUsado.propoe(new Lance(fran, 9000));
        carroUsado.propoe(new Lance(joao, 10000));

        leiloes.addAll(java.util.Arrays.asList(
                videogameNovo,
                computadorUsado,
                carroUsado));

        return leiloes;
    }

}