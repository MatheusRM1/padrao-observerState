package org.locacao;

public abstract class LocacaoEstado {

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
}
