package org.locacao;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LocacaoTest {

    Locacao locacao;

    @BeforeEach
    public void setUp() {
        locacao = new Locacao();
    }

    @Test
    public void deveReservarLocacaoDisponivel() {
        LocacaoEstadoDisponivel estado = LocacaoEstadoDisponivel.getInstance();
        locacao.setEstado(estado);
        Cliente cliente = new Cliente("Cliente 1");
        cliente.acompanhar(estado);

        assertTrue(locacao.reservar());
        assertEquals(LocacaoEstadoReservado.getInstance(), locacao.getEstado());
        assertEquals("Cliente 1, a locação está Disponivel", cliente.getUltimaNotificacao());
    }

    @Test
    public void naoDeveColocarEmAndamentoLocacaoDisponivel() {
        LocacaoEstadoDisponivel estado = LocacaoEstadoDisponivel.getInstance();
        locacao.setEstado(estado);
        Cliente cliente = new Cliente("Cliente 1");
        cliente.acompanhar(estado);

        assertFalse(locacao.emAndamento());
        assertNull(cliente.getUltimaNotificacao());
    }

    @Test
    public void naoDeveCancelarLocacaoDisponivel() {
        LocacaoEstadoDisponivel estado = LocacaoEstadoDisponivel.getInstance();
        locacao.setEstado(estado);
        Cliente cliente = new Cliente("Cliente 1");
        cliente.acompanhar(estado);

        assertFalse(locacao.cancelar());
        assertNull(cliente.getUltimaNotificacao());
    }

    @Test
    public void naoDeveFinalizarLocacaoDisponivel() {
        LocacaoEstadoDisponivel estado = LocacaoEstadoDisponivel.getInstance();
        locacao.setEstado(estado);
        Cliente cliente = new Cliente("Cliente 1");
        cliente.acompanhar(estado);

        assertFalse(locacao.finalizar());
        assertNull(cliente.getUltimaNotificacao());
    }

    @Test
    public void naoDeveDisponibilizarLocacaoDisponivel() {
        LocacaoEstadoDisponivel estado = LocacaoEstadoDisponivel.getInstance();
        locacao.setEstado(estado);
        Cliente cliente = new Cliente("Cliente 1");
        cliente.acompanhar(estado);

        assertFalse(locacao.disponivel());
        assertNull(cliente.getUltimaNotificacao());
    }

    @Test
    public void naoDeveUltrapassarPrazoLocacaoDisponivel() {
        LocacaoEstadoDisponivel estado = LocacaoEstadoDisponivel.getInstance();
        locacao.setEstado(estado);
        Cliente cliente = new Cliente("Cliente 1");
        cliente.acompanhar(estado);

        assertFalse(locacao.emAtraso());
        assertNull(cliente.getUltimaNotificacao());
    }

    @Test
    public void naoDeveReservarLocacaoReservada() {
        LocacaoEstadoReservado estado = LocacaoEstadoReservado.getInstance();
        locacao.setEstado(estado);
        Cliente cliente = new Cliente("Cliente 1");
        cliente.acompanhar(estado);

        assertFalse(locacao.reservar());
        assertNull(cliente.getUltimaNotificacao());
    }

    @Test
    public void deveColocarEmAndamentoLocacaoReservada() {
        LocacaoEstadoReservado estado = LocacaoEstadoReservado.getInstance();
        locacao.setEstado(estado);
        Cliente cliente = new Cliente("Cliente 1");
        cliente.acompanhar(estado);

        assertTrue(locacao.emAndamento());
        assertEquals(LocacaoEstadoEmAndamento.getInstance(), locacao.getEstado());
        assertEquals("Cliente 1, a locação está Reservado", cliente.getUltimaNotificacao());
    }

    @Test
    public void deveCancelarLocacaoReservada() {
        LocacaoEstadoReservado estado = LocacaoEstadoReservado.getInstance();
        locacao.setEstado(estado);
        Cliente cliente = new Cliente("Cliente 1");
        cliente.acompanhar(estado);

        assertTrue(locacao.cancelar());
        assertEquals(LocacaoEstadoCancelada.getInstance(), locacao.getEstado());
        assertEquals("Cliente 1, a locação está Reservado", cliente.getUltimaNotificacao());
    }

    @Test
    public void naoDeveFinalizarLocacaoReservada() {
        LocacaoEstadoReservado estado = LocacaoEstadoReservado.getInstance();
        locacao.setEstado(estado);
        Cliente cliente = new Cliente("Cliente 1");
        cliente.acompanhar(estado);

        assertFalse(locacao.finalizar());
        assertNull(cliente.getUltimaNotificacao());
    }

    @Test
    public void naoDeveDisponibilizarLocacaoReservada() {
        LocacaoEstadoReservado estado = LocacaoEstadoReservado.getInstance();
        locacao.setEstado(estado);
        Cliente cliente = new Cliente("Cliente 1");
        cliente.acompanhar(estado);

        assertFalse(locacao.disponivel());
        assertNull(cliente.getUltimaNotificacao());
    }

    @Test
    public void naoDeveUltrapassarPrazoLocacaoReservada() {
        LocacaoEstadoReservado estado = LocacaoEstadoReservado.getInstance();
        locacao.setEstado(estado);
        Cliente cliente = new Cliente("Cliente 1");
        cliente.acompanhar(estado);

        assertFalse(locacao.emAtraso());
        assertNull(cliente.getUltimaNotificacao());
    }

    @Test
    public void naoDeveReservarLocacaoEmAndamento() {
        LocacaoEstadoEmAndamento estado = LocacaoEstadoEmAndamento.getInstance();
        locacao.setEstado(estado);
        Cliente cliente = new Cliente("Cliente 1");
        cliente.acompanhar(estado);

        assertFalse(locacao.reservar());
        assertNull(cliente.getUltimaNotificacao());
    }

    @Test
    public void naoDeveColocarEmAndamentoLocacaoEmAndamento() {
        LocacaoEstadoEmAndamento estado = LocacaoEstadoEmAndamento.getInstance();
        locacao.setEstado(estado);
        Cliente cliente = new Cliente("Cliente 1");
        cliente.acompanhar(estado);

        assertFalse(locacao.emAndamento());
        assertNull(cliente.getUltimaNotificacao());
    }

    @Test
    public void naoDeveCancelarLocacaoEmAndamento() {
        LocacaoEstadoEmAndamento estado = LocacaoEstadoEmAndamento.getInstance();
        locacao.setEstado(estado);
        Cliente cliente = new Cliente("Cliente 1");
        cliente.acompanhar(estado);

        assertFalse(locacao.cancelar());
        assertNull(cliente.getUltimaNotificacao());
    }

    @Test
    public void deveFinalizarLocacaoEmAndamento() {
        LocacaoEstadoEmAndamento estado = LocacaoEstadoEmAndamento.getInstance();
        locacao.setEstado(estado);
        Cliente cliente = new Cliente("Cliente 1");
        cliente.acompanhar(estado);

        assertTrue(locacao.finalizar());
        assertEquals(LocacaoEstadoFinalizada.getInstance(), locacao.getEstado());
        assertEquals("Cliente 1, a locação está Em Andamento", cliente.getUltimaNotificacao());
    }

    @Test
    public void naoDeveDisponibilizarLocacaoEmAndamento() {
        LocacaoEstadoEmAndamento estado = LocacaoEstadoEmAndamento.getInstance();
        locacao.setEstado(estado);
        Cliente cliente = new Cliente("Cliente 1");
        cliente.acompanhar(estado);

        assertFalse(locacao.disponivel());
        assertNull(cliente.getUltimaNotificacao());
    }

    @Test
    public void deveUltrapassarPrazoLocacaoEmAndamento() {
        LocacaoEstadoEmAndamento estado = LocacaoEstadoEmAndamento.getInstance();
        locacao.setEstado(estado);
        Cliente cliente = new Cliente("Cliente 1");
        cliente.acompanhar(estado);

        assertTrue(locacao.emAtraso());
        assertEquals(LocacaoEstadoAtrasado.getInstance(), locacao.getEstado());
        assertEquals("Cliente 1, a locação está Em Andamento", cliente.getUltimaNotificacao());
    }

    @Test
    public void naoDeveReservarLocacaoAtrasada() {
        LocacaoEstadoAtrasado estado = LocacaoEstadoAtrasado.getInstance();
        locacao.setEstado(estado);
        Cliente cliente = new Cliente("Cliente 1");
        cliente.acompanhar(estado);

        assertFalse(locacao.reservar());
        assertNull(cliente.getUltimaNotificacao());
    }

    @Test
    public void naoDeveColocarEmAndamentoLocacaoAtrasada() {
        LocacaoEstadoAtrasado estado = LocacaoEstadoAtrasado.getInstance();
        locacao.setEstado(estado);
        Cliente cliente = new Cliente("Cliente 1");
        cliente.acompanhar(estado);

        assertFalse(locacao.emAndamento());
        assertNull(cliente.getUltimaNotificacao());
    }

    @Test
    public void naoDeveCancelarLocacaoAtrasada() {
        LocacaoEstadoAtrasado estado = LocacaoEstadoAtrasado.getInstance();
        locacao.setEstado(estado);
        Cliente cliente = new Cliente("Cliente 1");
        cliente.acompanhar(estado);

        assertFalse(locacao.cancelar());
        assertNull(cliente.getUltimaNotificacao());
    }

    @Test
    public void deveFinalizarLocacaoAtrasada() {
        LocacaoEstadoAtrasado estado = LocacaoEstadoAtrasado.getInstance();
        locacao.setEstado(estado);
        Cliente cliente = new Cliente("Cliente 1");
        cliente.acompanhar(estado);

        assertTrue(locacao.finalizar());
        assertEquals(LocacaoEstadoFinalizada.getInstance(), locacao.getEstado());
        assertEquals("Cliente 1, a locação está Atrasado", cliente.getUltimaNotificacao());
    }

    @Test
    public void naoDeveDisponibilizarLocacaoAtrasada() {
        LocacaoEstadoAtrasado estado = LocacaoEstadoAtrasado.getInstance();
        locacao.setEstado(estado);
        Cliente cliente = new Cliente("Cliente 1");
        cliente.acompanhar(estado);

        assertFalse(locacao.disponivel());
        assertNull(cliente.getUltimaNotificacao());
    }

    @Test
    public void naoDeveUltrapassarPrazoLocacaoAtrasada() {
        LocacaoEstadoAtrasado estado = LocacaoEstadoAtrasado.getInstance();
        locacao.setEstado(estado);
        Cliente cliente = new Cliente("Cliente 1");
        cliente.acompanhar(estado);

        assertFalse(locacao.emAtraso());
        assertNull(cliente.getUltimaNotificacao());
    }

    @Test
    public void naoDeveReservarLocacaoFinalizada() {
        LocacaoEstadoFinalizada estado = LocacaoEstadoFinalizada.getInstance();
        locacao.setEstado(estado);
        Cliente cliente = new Cliente("Cliente 1");
        cliente.acompanhar(estado);

        assertFalse(locacao.reservar());
        assertNull(cliente.getUltimaNotificacao());
    }

    @Test
    public void naoDeveColocarEmAndamentoLocacaoFinalizada() {
        LocacaoEstadoFinalizada estado = LocacaoEstadoFinalizada.getInstance();
        locacao.setEstado(estado);
        Cliente cliente = new Cliente("Cliente 1");
        cliente.acompanhar(estado);

        assertFalse(locacao.emAndamento());
        assertNull(cliente.getUltimaNotificacao());
    }

    @Test
    public void naoDeveCancelarLocacaoFinalizada() {
        LocacaoEstadoFinalizada estado = LocacaoEstadoFinalizada.getInstance();
        locacao.setEstado(estado);
        Cliente cliente = new Cliente("Cliente 1");
        cliente.acompanhar(estado);

        assertFalse(locacao.cancelar());
        assertNull(cliente.getUltimaNotificacao());
    }

    @Test
    public void naoDeveFinalizarLocacaoFinalizada() {
        LocacaoEstadoFinalizada estado = LocacaoEstadoFinalizada.getInstance();
        locacao.setEstado(estado);
        Cliente cliente = new Cliente("Cliente 1");
        cliente.acompanhar(estado);

        assertFalse(locacao.finalizar());
        assertNull(cliente.getUltimaNotificacao());
    }

    @Test
    public void naoDeveDisponibilizarLocacaoFinalizada() {
        LocacaoEstadoFinalizada estado = LocacaoEstadoFinalizada.getInstance();
        locacao.setEstado(estado);
        Cliente cliente = new Cliente("Cliente 1");
        cliente.acompanhar(estado);

        assertFalse(locacao.disponivel());
        assertNull(cliente.getUltimaNotificacao());
    }

    @Test
    public void naoDeveUltrapassarPrazoLocacaoFinalizada() {
        LocacaoEstadoFinalizada estado = LocacaoEstadoFinalizada.getInstance();
        locacao.setEstado(estado);
        Cliente cliente = new Cliente("Cliente 1");
        cliente.acompanhar(estado);

        assertFalse(locacao.emAtraso());
        assertNull(cliente.getUltimaNotificacao());
    }

    @Test
    public void naoDeveReservarLocacaoCancelada() {
        LocacaoEstadoCancelada estado = LocacaoEstadoCancelada.getInstance();
        locacao.setEstado(estado);
        Cliente cliente = new Cliente("Cliente 1");
        cliente.acompanhar(estado);

        assertFalse(locacao.reservar());
        assertNull(cliente.getUltimaNotificacao());
    }

    @Test
    public void naoDeveColocarEmAndamentoLocacaoCancelada() {
        LocacaoEstadoCancelada estado = LocacaoEstadoCancelada.getInstance();
        locacao.setEstado(estado);
        Cliente cliente = new Cliente("Cliente 1");
        cliente.acompanhar(estado);

        assertFalse(locacao.emAndamento());
        assertNull(cliente.getUltimaNotificacao());
    }

    @Test
    public void naoDeveCancelarLocacaoCancelada() {
        LocacaoEstadoCancelada estado = LocacaoEstadoCancelada.getInstance();
        locacao.setEstado(estado);
        Cliente cliente = new Cliente("Cliente 1");
        cliente.acompanhar(estado);

        assertFalse(locacao.cancelar());
        assertNull(cliente.getUltimaNotificacao());
    }

    @Test
    public void naoDeveFinalizarLocacaoCancelada() {
        LocacaoEstadoCancelada estado = LocacaoEstadoCancelada.getInstance();
        locacao.setEstado(estado);
        Cliente cliente = new Cliente("Cliente 1");
        cliente.acompanhar(estado);

        assertFalse(locacao.finalizar());
        assertNull(cliente.getUltimaNotificacao());
    }

    @Test
    public void naoDeveDisponibilizarLocacaoCancelada() {
        LocacaoEstadoCancelada estado = LocacaoEstadoCancelada.getInstance();
        locacao.setEstado(estado);
        Cliente cliente = new Cliente("Cliente 1");
        cliente.acompanhar(estado);

        assertFalse(locacao.disponivel());
        assertNull(cliente.getUltimaNotificacao());
    }

    @Test
    public void naoDeveUltrapassarPrazoLocacaoCancelada() {
        LocacaoEstadoCancelada estado = LocacaoEstadoCancelada.getInstance();
        locacao.setEstado(estado);
        Cliente cliente = new Cliente("Cliente 1");
        cliente.acompanhar(estado);

        assertFalse(locacao.emAtraso());
        assertNull(cliente.getUltimaNotificacao());
    }

    @Test
    public void deveNotificarUmCliente() {
        LocacaoEstadoEmAndamento estado = LocacaoEstadoEmAndamento.getInstance();
        locacao.setEstado(estado);
        Cliente cliente = new Cliente("Cliente 1");
        cliente.acompanhar(estado);

        locacao.finalizar();

        assertEquals("Cliente 1, a locação está Em Andamento", cliente.getUltimaNotificacao());
    }

    @Test
    public void deveNotificarClientes() {
        LocacaoEstadoEmAndamento estado = LocacaoEstadoEmAndamento.getInstance();
        locacao.setEstado(estado);
        Cliente cliente1 = new Cliente("Cliente 1");
        Cliente cliente2 = new Cliente("Cliente 2");
        cliente1.acompanhar(estado);
        cliente2.acompanhar(estado);

        locacao.finalizar();

        assertEquals("Cliente 1, a locação está Em Andamento", cliente1.getUltimaNotificacao());
        assertEquals("Cliente 2, a locação está Em Andamento", cliente2.getUltimaNotificacao());
    }

    @Test
    public void naoDeveNotificarCliente() {
        LocacaoEstadoEmAndamento estado = LocacaoEstadoEmAndamento.getInstance();
        locacao.setEstado(estado);
        Cliente cliente = new Cliente("Cliente 1");

        locacao.finalizar();

        assertNull(cliente.getUltimaNotificacao());
    }

    @Test
    public void deveNotificarClienteEstadoEmAndamento() {
        LocacaoEstadoEmAndamento estadoA = LocacaoEstadoEmAndamento.getInstance();
        LocacaoEstadoDisponivel estadoB = LocacaoEstadoDisponivel.getInstance();
        locacao.setEstado(estadoA);
        Cliente cliente1 = new Cliente("Cliente 1");
        Cliente cliente2 = new Cliente("Cliente 2");
        cliente1.acompanhar(estadoA);
        cliente2.acompanhar(estadoB);

        locacao.finalizar();

        assertEquals("Cliente 1, a locação está Em Andamento", cliente1.getUltimaNotificacao());
        assertNull(cliente2.getUltimaNotificacao());
    }
}