package org.locacao;

import java.util.Observable;

public abstract class LocacaoEstado extends Observable {

    public abstract String getEstado();

    public boolean reservar(Locacao locacao) {
        return false;
    }

    public boolean emAndamento(Locacao locacao) {
        return false;
    }

    public boolean cancelar(Locacao locacao) {
        return false;
    }

    public boolean finalizar(Locacao locacao) {
        return false;
    }

    public boolean disponivel(Locacao locacao) {
        return false;
    }

    public boolean emAtraso(Locacao locacao) {
        return false;
    }

    public void notificar() {
        setChanged();
        notifyObservers();
    }

    @Override
    public String toString() {
        return getEstado();
    }
}
