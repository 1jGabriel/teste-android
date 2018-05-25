package br.com.alura.leilao.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Leilao implements Serializable {

    private final String descricao;
    private final List<Lance> lances;
    private double maiorDeTodos = Double.NEGATIVE_INFINITY;
    private double menorDeTodos = Double.POSITIVE_INFINITY;

    public Leilao(String descricao) {
        this.descricao = descricao;
        this.lances = new ArrayList<>();
    }

    public void propoe(Lance lance) {

        if (!lances.isEmpty()) {
            Lance ultimoLance = lances.get(0);

            if (ultimoLance.getValor() >= lance.getValor()) {
                return;
            }

            Usuario usuario = lance.getUsuario();
            Usuario ultimoUsuario = ultimoLance.getUsuario();
            if (usuario.equals(ultimoUsuario)) {
                return;
            }
        }

        lances.add(lance);
        double valor = lance.getValor();
        if (valor > maiorDeTodos) maiorDeTodos = valor;
        if (valor < menorDeTodos) menorDeTodos = valor;
        Collections.sort(lances);
    }

    public String getDescricao() {
        return descricao;
    }

    public double getMaiorDeTodos() {
        return maiorDeTodos;
    }

    public double getMenorDeTodos() {
        return menorDeTodos;
    }

    public List<Lance> tresMaiores() {
        int totalLances = lances.size();
        return lances.subList(0, lances.size() > 3 ? 3 : totalLances);
    }

    public List<Lance> getLances() {
        return Collections.unmodifiableList(lances);
    }
}
