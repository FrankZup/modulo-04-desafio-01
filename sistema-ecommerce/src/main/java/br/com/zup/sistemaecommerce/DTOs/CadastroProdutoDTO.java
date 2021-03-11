package br.com.zup.sistemaecommerce.DTOs;

public class CadastroProdutoDTO {
    private String nome;

    public CadastroProdutoDTO() { }

    public CadastroProdutoDTO(String nome) {
        this.nome = nome;
    }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
}
