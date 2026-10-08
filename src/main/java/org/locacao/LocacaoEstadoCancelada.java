package org.locacao;

public class LocacaoEstadoCancelada extends LocacaoEstado{

    private LocacaoEstadoCancelada() {};
    private static LocacaoEstadoCancelada instance = new LocacaoEstadoCancelada();
    public static LocacaoEstadoCancelada getInstance() {
        return instance;
    }


    @Override
    public String getEstado() {
        return "Cancelado";
    }
}
