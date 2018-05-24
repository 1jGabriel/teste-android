package br.com.alura.leilao.model;

public class Avaliador {

    private Double maiorDeTodos = Double.NEGATIVE_INFINITY;
    private Double menorDeTodos = Double.POSITIVE_INFINITY;

    public void avalia(Leilao leilao) {
        for (Lance lance :
                leilao.getLances()) {
            double valor = lance.getValor();
            if (valor > maiorDeTodos) maiorDeTodos = valor;
            if (valor < menorDeTodos) menorDeTodos = valor;
        }
    }

    public Double getMaiorDeTodos() {
        return maiorDeTodos;
    }

    public Double getMenorDeTodos() {
        return menorDeTodos;
    }

}
