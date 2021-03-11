package br.com.zup.sistemaecommerce.DTOs;
import br.com.zup.sistemaecommerce.models.Cliente;
import br.com.zup.sistemaecommerce.models.Compra;
import br.com.zup.sistemaecommerce.models.Produto;
import org.hibernate.validator.constraints.br.CPF;

import java.util.List;

public class CadastroCompraDTO {

    @CPF(message = "CPF invalido")
    private String cpf;
    private List<CadastroProdutoDTO> produtos;

    public CadastroCompraDTO() {}

    public CadastroCompraDTO(String cpf, List<CadastroProdutoDTO> produtos) {
        this.cpf      = cpf;
        this.produtos = produtos ;
    }

    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }

    public List<CadastroProdutoDTO> getProdutos() { return produtos; }
    public void setProdutos(List<CadastroProdutoDTO> produtos) {
        this.produtos = produtos;
    }

    public Compra converterDTOparaCompra(Cliente cliente, List<Produto> listaProdutos){
        Compra compra = new Compra();
        compra.setCliente(cliente);
        System.out.println(listaProdutos);
        compra.setListaDeProdutos(listaProdutos);

        return compra;
    }
}

