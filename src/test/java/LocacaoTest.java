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

    // Locacao Disponível

    @Test
    public void deveReservarLocacaoDisponivel() {
        locacao.setEstado(LocacaoEstadoDisponivel.getInstance());
        assertTrue(locacao.reservar());
        assertEquals(LocacaoEstadoReservado.getInstance(), locacao.getEstado());
    }

    @Test
    public void naoDeveColocarEmAndamentoLocacaoDisponivel() {
        locacao.setEstado(LocacaoEstadoDisponivel.getInstance());
        assertFalse(locacao.emAndamento());
    }

    @Test
    public void naoDeveCancelarLocacaoDisponivel() {
        locacao.setEstado(LocacaoEstadoDisponivel.getInstance());
        assertFalse(locacao.cancelar());
    }

    @Test
    public void naoDeveFinalizarLocacaoDisponivel() {
        locacao.setEstado(LocacaoEstadoDisponivel.getInstance());
        assertFalse(locacao.finalizar());
    }

    @Test
    public void naoDeveDisponibilizarLocacaoDisponivel() {
        locacao.setEstado(LocacaoEstadoDisponivel.getInstance());
        assertFalse(locacao.disponivel());
    }

    @Test
    public void naoDeveUltrapassarPrazoLocacaoDisponivel() {
        locacao.setEstado(LocacaoEstadoDisponivel.getInstance());
        assertFalse(locacao.emAtraso());
    }


    // Locacao Reservada

    @Test
    public void naoDeveReservarLocacaoReservada() {
        locacao.setEstado(LocacaoEstadoReservado.getInstance());
        assertFalse(locacao.reservar());
    }

    @Test
    public void deveColocarEmAndamentoLocacaoReservada() {
        locacao.setEstado(LocacaoEstadoReservado.getInstance());
        assertTrue(locacao.emAndamento());
        assertEquals(LocacaoEstadoEmAndamento.getInstance(), locacao.getEstado());
    }

    @Test
    public void deveCancelarLocacaoReservada() {
        locacao.setEstado(LocacaoEstadoReservado.getInstance());
        assertTrue(locacao.cancelar());
        assertEquals(LocacaoEstadoCancelada.getInstance(), locacao.getEstado());
    }

    @Test
    public void naoDeveFinalizarLocacaoReservada() {
        locacao.setEstado(LocacaoEstadoReservado.getInstance());
        assertFalse(locacao.finalizar());
    }

    @Test
    public void naoDeveDisponibilizarLocacaoReservada() {
        locacao.setEstado(LocacaoEstadoReservado.getInstance());
        assertFalse(locacao.disponivel());
    }

    @Test
    public void naoDeveUltrapassarPrazoLocacaoReservada() {
        locacao.setEstado(LocacaoEstadoReservado.getInstance());
        assertFalse(locacao.emAtraso());
    }


    // Locacao Em Andamento

    @Test
    public void naoDeveReservarLocacaoEmAndamento() {
        locacao.setEstado(LocacaoEstadoEmAndamento.getInstance());
        assertFalse(locacao.reservar());
    }

    @Test
    public void naoDeveColocarEmAndamentoLocacaoEmAndamento() {
        locacao.setEstado(LocacaoEstadoEmAndamento.getInstance());
        assertFalse(locacao.emAndamento());
    }

    @Test
    public void naoDeveCancelarLocacaoEmAndamento() {
        locacao.setEstado(LocacaoEstadoEmAndamento.getInstance());
        assertFalse(locacao.cancelar());
    }

    @Test
    public void deveFinalizarLocacaoEmAndamento() {
        locacao.setEstado(LocacaoEstadoEmAndamento.getInstance());
        assertTrue(locacao.finalizar());
        assertEquals(LocacaoEstadoFinalizada.getInstance(), locacao.getEstado());
    }

    @Test
    public void naoDeveDisponibilizarLocacaoEmAndamento() {
        locacao.setEstado(LocacaoEstadoEmAndamento.getInstance());
        assertFalse(locacao.disponivel());
    }

    @Test
    public void deveUltrapassarPrazoLocacaoEmAndamento() {
        locacao.setEstado(LocacaoEstadoEmAndamento.getInstance());
        assertTrue(locacao.emAtraso());
        assertEquals(LocacaoEstadoAtrasado.getInstance(), locacao.getEstado());
    }


    // Locacao Atrasada

    @Test
    public void naoDeveReservarLocacaoAtrasada() {
        locacao.setEstado(LocacaoEstadoAtrasado.getInstance());
        assertFalse(locacao.reservar());
    }

    @Test
    public void naoDeveColocarEmAndamentoLocacaoAtrasada() {
        locacao.setEstado(LocacaoEstadoAtrasado.getInstance());
        assertFalse(locacao.emAndamento());
    }

    @Test
    public void naoDeveCancelarLocacaoAtrasada() {
        locacao.setEstado(LocacaoEstadoAtrasado.getInstance());
        assertFalse(locacao.cancelar());
    }

    @Test
    public void deveFinalizarLocacaoAtrasada() {
        locacao.setEstado(LocacaoEstadoAtrasado.getInstance());
        assertTrue(locacao.finalizar());
        assertEquals(LocacaoEstadoFinalizada.getInstance(), locacao.getEstado());
    }

    @Test
    public void naoDeveDisponibilizarLocacaoAtrasada() {
        locacao.setEstado(LocacaoEstadoAtrasado.getInstance());
        assertFalse(locacao.disponivel());
    }

    @Test
    public void naoDeveUltrapassarPrazoLocacaoAtrasada() {
        locacao.setEstado(LocacaoEstadoAtrasado.getInstance());
        assertFalse(locacao.emAtraso());
    }


    // Locacao Finalizada

    @Test
    public void naoDeveReservarLocacaoFinalizada() {
        locacao.setEstado(LocacaoEstadoFinalizada.getInstance());
        assertFalse(locacao.reservar());
    }

    @Test
    public void naoDeveColocarEmAndamentoLocacaoFinalizada() {
        locacao.setEstado(LocacaoEstadoFinalizada.getInstance());
        assertFalse(locacao.emAndamento());
    }

    @Test
    public void naoDeveCancelarLocacaoFinalizada() {
        locacao.setEstado(LocacaoEstadoFinalizada.getInstance());
        assertFalse(locacao.cancelar());
    }

    @Test
    public void naoDeveFinalizarLocacaoFinalizada() {
        locacao.setEstado(LocacaoEstadoFinalizada.getInstance());
        assertFalse(locacao.finalizar());
    }

    @Test
    public void naoDeveDisponibilizarLocacaoFinalizada() {
        locacao.setEstado(LocacaoEstadoFinalizada.getInstance());
        assertFalse(locacao.disponivel());
    }

    @Test
    public void naoDeveUltrapassarPrazoLocacaoFinalizada() {
        locacao.setEstado(LocacaoEstadoFinalizada.getInstance());
        assertFalse(locacao.emAtraso());
    }


    // Locacao Cancelada

    @Test
    public void naoDeveReservarLocacaoCancelada() {
        locacao.setEstado(LocacaoEstadoCancelada.getInstance());
        assertFalse(locacao.reservar());
    }

    @Test
    public void naoDeveColocarEmAndamentoLocacaoCancelada() {
        locacao.setEstado(LocacaoEstadoCancelada.getInstance());
        assertFalse(locacao.emAndamento());
    }

    @Test
    public void naoDeveCancelarLocacaoCancelada() {
        locacao.setEstado(LocacaoEstadoCancelada.getInstance());
        assertFalse(locacao.cancelar());
    }

    @Test
    public void naoDeveFinalizarLocacaoCancelada() {
        locacao.setEstado(LocacaoEstadoCancelada.getInstance());
        assertFalse(locacao.finalizar());
    }

    @Test
    public void naoDeveDisponibilizarLocacaoCancelada() {
        locacao.setEstado(LocacaoEstadoCancelada.getInstance());
        assertFalse(locacao.disponivel());
    }

    @Test
    public void naoDeveUltrapassarPrazoLocacaoCancelada() {
        locacao.setEstado(LocacaoEstadoCancelada.getInstance());
        assertFalse(locacao.emAtraso());
    }

}