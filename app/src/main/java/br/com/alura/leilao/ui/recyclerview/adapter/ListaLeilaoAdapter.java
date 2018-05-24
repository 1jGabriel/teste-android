package br.com.alura.leilao.ui.recyclerview.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import br.com.alura.leilao.R;
import br.com.alura.leilao.model.Avaliador;
import br.com.alura.leilao.model.Leilao;

public class ListaLeilaoAdapter extends RecyclerView.Adapter<ListaLeilaoAdapter.ViewHolder> {

    private final List<Leilao> leiloes;
    private final Avaliador avaliador;
    private Context context;

    public ListaLeilaoAdapter(Context context) {
        this.context = context;
        leiloes = new ArrayList<>();
        avaliador = new Avaliador();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View viewCriada = LayoutInflater.from(context).inflate(R.layout.item_leilao, parent, false);
        return new ViewHolder(viewCriada);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Leilao leilao = leiloes.get(position);
        holder.vincula(leilao);
    }

    @Override
    public int getItemCount() {
        return leiloes.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView descricao;
        private final TextView maiorLance;

        public ViewHolder(View itemView) {
            super(itemView);
            descricao = itemView.findViewById(R.id.item_leilao_descricao);
            maiorLance = itemView.findViewById(R.id.item_leilao_maior_lance);
        }

        public void vincula(Leilao leilao) {
            descricao.setText(leilao.getDescricao());
            avaliador.avalia(leilao);
            maiorLance.setText(avaliador.getMaiorDeTodos().toString());
        }
    }
}
