package org.locacao;

import java.util.Observable;
import java.util.Observer;

public class Cliente implements Observer {

    private String nome;
    private String ultimaNotificacao;

    public Cliente(String nome) {
        this.nome = nome;
    }

    public String getUltimaNotificacao() {
        return this.ultimaNotificacao;
    }

    public void acompanhar(LocacaoEstado estado) {
        estado.addObserver(this);
    }

    public void update(Observable estado, Object arg) {
        this.ultimaNotificacao = this.nome + ", a locação está " + estado.toString();
    }
}