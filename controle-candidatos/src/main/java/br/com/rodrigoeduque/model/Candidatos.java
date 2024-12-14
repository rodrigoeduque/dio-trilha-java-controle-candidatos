package br.com.rodrigoeduque.model;

public class Candidatos {

    private String nome;
    private Double salarioPretendido;

    public Candidatos(String nome, Double salarioPretendido) {
        this.nome = nome;
        this.salarioPretendido = salarioPretendido;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getSalarioPretendido() {
        return salarioPretendido;
    }

    public void setSalarioPretendido(Double salarioPretendido) {
        this.salarioPretendido = salarioPretendido;
    }
}
