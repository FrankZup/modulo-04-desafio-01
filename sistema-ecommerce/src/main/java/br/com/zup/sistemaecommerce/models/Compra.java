package br.com.zup.sistemaecommerce.models;

import java.util.List;

public class Compra {
    private Cliente cliente;
    private List<Produto> listaDeProdutos;

    public Compra() { }

    public Compra(Cliente cliente, List<Produto> listaDeProdutos) {
        this.cliente = cliente;
        this.listaDeProdutos = listaDeProdutos;
    }

    public Cliente getCliente() { return cliente; }
    public void setCliente(Cliente cliente) { this.cliente = cliente; }

    public List<Produto> getListaDeProdutos() { return listaDeProdutos; }
    public void setListaDeProdutos(List<Produto> listaDeProdutos) {
        this.listaDeProdutos = listaDeProdutos;
    }
}
