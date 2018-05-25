package br.com.alura.leilao.ui.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.com.alura.leilao.R;
import br.com.alura.leilao.model.Lance;
import br.com.alura.leilao.model.Leilao;
import br.com.alura.leilao.model.Usuario;
import br.com.alura.leilao.ui.recyclerview.adapter.ListaLeilaoAdapter;

public class ListaLeilaoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_leilao);
        configuraRecyclerView();
    }

    private void configuraRecyclerView() {
        RecyclerView listaLeiloes = findViewById(R.id.lista_leilao_recyclerview);
        ListaLeilaoAdapter adapter = new ListaLeilaoAdapter(this);
        listaLeiloes.setAdapter(adapter);
        adapter.adiciona(leiloesDeExemplo());
        adapter.setOnItemClickListener(new ListaLeilaoAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Leilao leilao) {
                Intent vaiParaLancesDoLeilao = new Intent(ListaLeilaoActivity.this, LancesLeilaoActivity.class);
                vaiParaLancesDoLeilao.putExtra("leilao", leilao);
                startActivity(vaiParaLancesDoLeilao);
            }
        });
    }

    public List<Leilao> leiloesDeExemplo() {
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

        leiloes.addAll(Arrays.asList(
                videogameNovo,
                computadorUsado,
                carroUsado));

        return leiloes;
    }
}
