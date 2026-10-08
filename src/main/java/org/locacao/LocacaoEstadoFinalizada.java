package org.locacao;

public class LocacaoEstadoFinalizada extends LocacaoEstado{

    private LocacaoEstadoFinalizada() {};
    private static LocacaoEstadoFinalizada instance = new LocacaoEstadoFinalizada();
    public static LocacaoEstadoFinalizada getInstance() {
        return instance;
    }

    public String getEstado() {
        return "Finalizada";
    }
}
