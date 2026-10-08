package org.locacao;

public class Locacao {

    private String nome;
    private LocacaoEstado estado;

    public Locacao() {
        this.estado = LocacaoEstadoDisponivel.getInstance();
    }

    public void setEstado(LocacaoEstado estado) {
        this.estado = estado;
    }

    public boolean reservar() {
        return estado.reservar(this);
    }

    public boolean emAndamento() {
        return estado.emAndamento(this);
    }

    public boolean cancelar() {
        return estado.cancelar(this);
    }

    public boolean finalizar() {
        return estado.finalizar(this);
    }

    public boolean disponivel() {
        return estado.disponivel(this);
    }

    public boolean emAtraso() {
        return estado.emAtraso(this);
    }

    public String getNomeEstado() {
        return estado.getEstado();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocacaoEstado getEstado() {
        return estado;
    }
}
