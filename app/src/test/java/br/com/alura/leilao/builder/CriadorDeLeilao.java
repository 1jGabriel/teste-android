package br.com.alura.leilao.builder;

import br.com.alura.leilao.model.Lance;
import br.com.alura.leilao.model.Leilao;

public class CriadorDeLeilao {

    private final Leilao leilao;

    public CriadorDeLeilao(String descricao) {
        this.leilao = new Leilao(descricao);
    }

    public CriadorDeLeilao lance(Lance lance) {
        leilao.propoe(lance);
        return this;
    }

    public Leilao constroi() {
        return leilao;
    }
}
