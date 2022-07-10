package com.example.funcionariopag;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.*;

public class FuncionarioTest {

    public FuncionarioTest() {
    }

    @Test
    public void testarConstrutorPagamentoInvalido() {

        assertThrows(IllegalArgumentException.class, () -> {
            Funcionario funcionario = new Funcionario("FuncionarioTeste", 10, 49.0);
        });
    }

    @Test
    public void testarConstrutorEntradaValorHoraInvalida() {
        // O valor por hora precisa ser entre 4% e 10% do salário mínimo.
        assertThrows(IllegalArgumentException.class, () -> {
            Funcionario funcionario = new Funcionario("FuncionarioTeste", 40, 30.0);
        });
    }

    @Test
    public void testarConstrutorEntradaHorasInvalida() {
        assertThrows(IllegalArgumentException.class, () -> {
            Funcionario funcionario = new Funcionario("FuncionarioTeste", 41, 49.0);
        });
    }

    @Test
    public void testarConstrutorEntradasValida() {
        Funcionario funcionario = new Funcionario("FuncionarioTeste", 40, 49.0);
        // execução
        Double expected = 1960.0;

        assertEquals(expected, funcionario.calcularPagamento(40, 49.0));
    }

    @Test
    public void testarModificarHorasPagamentoInvalido() {
        Funcionario funcionario = new Funcionario("FuncionarioTeste", 35, 49.0);
        assertThrows(IllegalArgumentException.class, () -> {
            funcionario.setHorasTrabalhadas(10);
        });
    }

    @Test
    public void testarModificarHorasEntradaInvalida() {
        Funcionario funcionario = new Funcionario("FuncionarioTeste", 35, 49.0);
        assertThrows(IllegalArgumentException.class, () -> {
            funcionario.setHorasTrabalhadas(41);
        });
    }

    @Test
    public void testarModificarHorasEntradaValida() {
        Funcionario funcionario = new Funcionario("FuncionarioTeste", 35, 49.0);
        Double expected = 1960.0;

        funcionario.setHorasTrabalhadas(40);

        assertEquals(expected,
                funcionario.calcularPagamento(funcionario.getHorasTrabalhadas(), funcionario.getValorHora()));
    }

    @Test
    public void testarModificarValorPagamentoInvalido() {
        Funcionario funcionario = new Funcionario("FuncionarioTeste", 20, 80.0);
        assertThrows(IllegalArgumentException.class, () -> {
            funcionario.setValorHora(48.0);
            ;
        });
    }

    @Test
    public void testarModificarValorEntradaInvalida() {
        Funcionario funcionario = new Funcionario("FuncionarioTeste", 35, 49.0);
        assertThrows(IllegalArgumentException.class, () -> {
            funcionario.setValorHora(48.0);
            ;
        });
    }

    @Test
    public void testarModificarValorEntradaValida() {
        Funcionario funcionario = new Funcionario("FuncionarioTeste", 35, 49.0);
        Double expected = 1925.0;

        funcionario.setValorHora(55.0);

        assertEquals(expected,
                funcionario.calcularPagamento(funcionario.getHorasTrabalhadas(), funcionario.getValorHora()));
    }

}