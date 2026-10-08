package org.locacao;

public class LocacaoEstadoAtrasado extends LocacaoEstado{

    private LocacaoEstadoAtrasado() {};
    private static LocacaoEstadoAtrasado instance = new LocacaoEstadoAtrasado();
    public static LocacaoEstadoAtrasado getInstance() {
        return instance;
    }

    public String getEstado() {
        return "Atrasado";
    }

    public boolean finalizar(Locacao locacao) {
        locacao.setEstado(LocacaoEstadoFinalizada.getInstance());
        this.notificar();

        return true;
    }
}
