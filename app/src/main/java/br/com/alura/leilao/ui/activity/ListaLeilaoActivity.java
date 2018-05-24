package br.com.alura.leilao.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import br.com.alura.leilao.R;
import br.com.alura.leilao.ui.recyclerview.adapter.ListaLeilaoAdapter;

public class ListaLeilaoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_leilao);
        RecyclerView listaLeiloes = findViewById(R.id.lista_leilao_recyclerview);
        listaLeiloes.setAdapter(new ListaLeilaoAdapter(this));
    }
}
