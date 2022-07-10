package com.example.funcionariopag;

public class FuncionarioTerceirizado extends Funcionario {
    private String nome;
    private Integer horasTrabalhadas;
    private Double valorHora;
    private Double pagamento;

    public FuncionarioTerceirizado(String nome, Integer horasTrabalhadas, Double valorHora) {
        if (calcularPagamento(horasTrabalhadas, valorHora) == null)
            throw new IllegalArgumentException(
                    "Despesas não pode ultrapassar 1000 reais.");
        else {
            this.pagamento = calcularPagamento(horasTrabalhadas, valorHora);
            this.nome = nome;
            if (horasTrabalhadas > 40)
                throw new IllegalArgumentException("Os funcionários podem trabalhar por no máximo 40 horas.");
            else
                this.horasTrabalhadas = horasTrabalhadas;
            if (valorHora < (salarioMinimo * 0.04) || valorHora > (salarioMinimo * 0.1))
                throw new IllegalArgumentException("O valor por hora precisa ser entre 4% e 10% do salário mínimo.");
            else
                this.valorHora = valorHora;
        }
    }

    @Override
    public Double calcularPagamento(Integer horasTrabalhadas, Double valorHora) {
        Double pagamento = horasTrabalhadas * valorHora;
        Double despesas = pagamento * 1.10;
        if(despesas < 1000)
            return pagamento+despesas;
        else {
            return null;
        }
    }

    public Double getPagamento() {
        return pagamento;
    }


    @Override
    public void setValorHora(Double valorHora) {
        if (calcularPagamento(horasTrabalhadas, valorHora) == null)
            throw new IllegalArgumentException("Despesas não podem ultrapassar 1000 reais.");
        else {
           this.valorHora = valorHora;
           this.pagamento = calcularPagamento(horasTrabalhadas, valorHora);
        }

    }
}

