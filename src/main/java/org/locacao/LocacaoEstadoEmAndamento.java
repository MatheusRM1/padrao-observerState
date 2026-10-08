package org.locacao;

public class LocacaoEstadoEmAndamento extends LocacaoEstado{

    private LocacaoEstadoEmAndamento() {};
    private static LocacaoEstadoEmAndamento instance = new LocacaoEstadoEmAndamento();
    public static LocacaoEstadoEmAndamento getInstance() {
        return instance;
    }

    @Override
    public String getEstado() {
        return "Em Andamento";
    }

    @Override
    public boolean emAtraso(Locacao locacao) {
        locacao.setEstado(LocacaoEstadoAtrasado.getInstance());
        this.notificar();
        return true;
    }

    @Override
    public boolean finalizar(Locacao locacao) {
        locacao.setEstado(LocacaoEstadoFinalizada.getInstance());
        this.notificar();
        return true;
    }
}
