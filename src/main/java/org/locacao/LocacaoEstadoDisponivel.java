package org.locacao;

public class LocacaoEstadoDisponivel extends LocacaoEstado{

    private LocacaoEstadoDisponivel() {};
    private static LocacaoEstadoDisponivel instance = new LocacaoEstadoDisponivel();
    public static LocacaoEstadoDisponivel getInstance() {
        return instance;
    }

    @Override
    public String getEstado() {
        return "Disponivel";
    }

    @Override
    public boolean reservar(Locacao locacao) {
        locacao.setEstado(LocacaoEstadoReservado.getInstance());
        return true;
    }
}
