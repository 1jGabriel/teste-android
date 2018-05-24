package br.com.alura.leilao.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Leilao {

    private final String descricao;
    private final List<Lance> lances;

    public Leilao(String descricao) {
        this.descricao = descricao;
        this.lances = new ArrayList<>();
    }

    public void propoe(Lance lance) {
        lances.add(lance);
    }

    public String getDescricao() {
        return descricao;
    }

    public List<Lance> getLances() {
        return Collections.unmodifiableList(lances);
    }
}
