package br.com.zup.sistemaecommerce.models;

import javax.validation.constraints.Min;

public class Produto {
    private String nome;
    private double preco;
    @Min(1)
    private int quantidade;

    public Produto() {}

    public Produto(String nome) {
        this.nome = nome;
    }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public double getPreco() { return preco; }
    public void setPreco(double preco) { this.preco = preco; }

    public int getQuantidade() { return quantidade; }
    public void setQuantidade(int quantidade) { this.quantidade = quantidade; }
}
