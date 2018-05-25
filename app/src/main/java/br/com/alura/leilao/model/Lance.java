package br.com.alura.leilao.model;

import android.support.annotation.NonNull;
import android.util.Log;

import java.io.Serializable;

public class Lance implements Serializable, Comparable {

    private Usuario usuario;
    private double valor;

    public Lance(Usuario usuario, double valor) {
        this.usuario = usuario;
        this.valor = valor;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public double getValor() {
        return valor;
    }

    @Override
    public int compareTo(@NonNull Object o) {
        Lance lance = (Lance) o;
        if (this.getValor() < lance.getValor()) return 1;
        else if (this.getValor() > lance.getValor()) return -1;
        return 0;
    }

}
