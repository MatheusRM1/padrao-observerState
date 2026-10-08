package org.locacao;

public class LocacaoEstadoReservado extends LocacaoEstado{

    private LocacaoEstadoReservado() {};
    private static LocacaoEstadoReservado instance = new LocacaoEstadoReservado();
    public static LocacaoEstadoReservado getInstance() {
        return instance;
    }

    @Override
    public String getEstado() {
        return "Reservado";
    }

    public boolean emAndamento(Locacao locacao) {
        locacao.setEstado(LocacaoEstadoEmAndamento.getInstance());
        this.notificar();
        return true;
    }

    public boolean cancelar(Locacao locacao) {
        locacao.setEstado(LocacaoEstadoCancelada.getInstance());
        this.notificar();
        return true;
    }
}
