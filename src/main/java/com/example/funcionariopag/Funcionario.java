package com.example.funcionariopag;

public class Funcionario {
    private String nome;
    private Integer horasTrabalhadas;
    private Double valorHora;
    protected Double salarioMinimo = 1212.0;

    Funcionario() {
    };

    Funcionario(String nome, Integer horasTrabalhadas, Double valorHora) {
        if (calcularPagamento(horasTrabalhadas, valorHora) == null)
            throw new IllegalArgumentException(
                    "Pagamento deve ser maior ou igual ao valor atual do salário mínimo, R$ 1.212,00.");
        else {
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

    public Double calcularPagamento(Integer horasTrabalhadas, Double valorHora) {
        Double pagamento = horasTrabalhadas * valorHora;
        if (pagamento >= salarioMinimo)
            return pagamento;
        else {
            return null;
        }
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getHorasTrabalhadas() {
        return this.horasTrabalhadas;
    }

    public void setHorasTrabalhadas(Integer horasTrabalhadas) {
        if (calcularPagamento(horasTrabalhadas, valorHora) == null)
            throw new IllegalArgumentException(
                    "Pagamento deve ser maior ou igual ao valor atual do salário mínimo, R$ 1.212,00.");
        else {
            this.nome = nome;
            if (horasTrabalhadas > 40)
                throw new IllegalArgumentException("Os funcionários podem trabalhar por no máximo 40 horas.");
            else
                this.horasTrabalhadas = horasTrabalhadas;
        }
    }

    public Double getValorHora() {
        return this.valorHora;
    }

    public void setValorHora(Double valorHora) {
        if (calcularPagamento(horasTrabalhadas, valorHora) == null)
            throw new IllegalArgumentException(
                    "Pagamento deve ser maior ou igual ao valor atual do salário mínimo, R$ 1.212,00.");
        else {
            if (valorHora < (salarioMinimo * 0.04) || valorHora > (salarioMinimo * 0.1))
                throw new IllegalArgumentException("O valor por hora precisa ser entre 4% e 10% do salário mínimo.");
            else
                this.valorHora = valorHora;
        }
    }

    public Double getSalarioMinimo() {
        return this.salarioMinimo;
    }

    public void setSalarioMinimo(Double salarioMinimo) {
        this.salarioMinimo = salarioMinimo;
    }

}
