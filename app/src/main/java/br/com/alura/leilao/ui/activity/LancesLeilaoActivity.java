package br.com.alura.leilao.ui.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

import br.com.alura.leilao.R;
import br.com.alura.leilao.model.Lance;
import br.com.alura.leilao.model.Leilao;
import br.com.alura.leilao.formatter.FormataMoeda;

public class LancesLeilaoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lances_leilao);

        Intent intent = getIntent();
        if (intent.hasExtra("leilao")) {
            Leilao leilao = (Leilao) intent.getSerializableExtra("leilao");

            TextView descricao = findViewById(R.id.lances_leilao_descricao);
            descricao.setText(leilao.getDescricao());

            TextView menorLance = findViewById(R.id.lances_leilao_menor_lance);
            menorLance.setText(FormataMoeda.formata(leilao.getMenorDeTodos()));

            TextView maiorLance = findViewById(R.id.lances_leilao_maior_lance);
            maiorLance.setText(FormataMoeda.formata(leilao.getMaiorDeTodos()));

            List<Lance> tresMaiores = leilao.tresMaiores();

            TextView maioresLances = findViewById(R.id.lances_leilao_maiores_lances);

            StringBuilder sb = new StringBuilder();
            for (Lance lance :
                    tresMaiores) {
                sb.append(FormataMoeda.formata(lance.getValor()) + "\n");
            }
            maioresLances.setText(sb.toString());

        }

    }
}
