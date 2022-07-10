package com.example.funcionariopag;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FuncionarioTerceirizadoTest {

    public FuncionarioTerceirizadoTest() {
    }

    @Test
    public void testarConstrutorEntradaDespesasInvalida() {
        assertThrows(IllegalArgumentException.class, () -> {
            FuncionarioTerceirizado funcionario = new FuncionarioTerceirizado("FuncionarioTeste", 50, 49.0);
        });
    }

    @Test
    public void testarConstrutorEntradasValida() {
        FuncionarioTerceirizado funcionario = new FuncionarioTerceirizado("FuncionarioTeste", 10, 49.0);

        Double expected = 1029.0;

        assertEquals(expected, funcionario.getPagamento());
    }

    @Test
    public void testarModificarDespesasEntradaInvalida() {
        FuncionarioTerceirizado funcionario = new FuncionarioTerceirizado("FuncionarioTeste", 10, 49.0);

        assertThrows(IllegalArgumentException.class, () -> {
            funcionario.setValorHora(100.0);
        });
    }

    @Test
    public void testarModificarDespesasEntradaValida() {
        FuncionarioTerceirizado funcionario = new FuncionarioTerceirizado("FuncionarioTeste", 10, 49.0);

        Double expected = 315.0;

        funcionario.setValorHora(15.0);

        assertEquals(expected, funcionario.getPagamento());
    }
}