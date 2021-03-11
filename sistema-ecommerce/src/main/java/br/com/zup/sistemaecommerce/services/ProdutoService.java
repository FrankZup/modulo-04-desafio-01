package br.com.zup.sistemaecommerce.services;

import br.com.zup.sistemaecommerce.DTOs.CadastroCompraDTO;
import br.com.zup.sistemaecommerce.DTOs.CadastroProdutoDTO;
import br.com.zup.sistemaecommerce.exceptions.ExcecaoProdutoDuplicado;
import br.com.zup.sistemaecommerce.exceptions.ExecaoProdutoEmFalta;
import br.com.zup.sistemaecommerce.models.Compra;
import br.com.zup.sistemaecommerce.models.Produto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
/**
 * @author Franklin Hanemann
 * Classe que realiza todas as funcionalidades relacionadas a classe Produto:
 *      - Cadastrar Produto (com validação de produto ja cadastrado)
 *      - Pesquisar Cliente pelo Nome
 *      - Pesquisar Cliente
 *      - Criar lista de Compra
 *      - Atualizar quantidade do produto em estoque após efetuar a venda
 *
 */
@Service
public class ProdutoService {

    private List<Produto> listaProdutos = new ArrayList<>();

    public Produto cadastrarProduto(Produto produto){
        try {
            pesquisarProduto(produto);
        } catch (RuntimeException erro){
            listaProdutos.add(produto);
            return produto;
        }

        throw new ExcecaoProdutoDuplicado(produto.getNome());
    }


    public List<Produto> listarProdutos(){
        return listaProdutos;
    }

    public Produto pesquisarProdutoPeloNome(String nome){
        for (Produto objetoProduto : listaProdutos){
            if (objetoProduto.getNome().equalsIgnoreCase(nome)){
                return objetoProduto;
            }
        }

        throw new RuntimeException("Produto não encontrado");
    }

    public Produto pesquisarProduto(Produto produto){

        return pesquisarProdutoPeloNome(produto.getNome());
    }

    /**
     * Este metodo é responsavel por criar a lista de compras, percorendo a lista de produto,
     * que caso encontrado e a quantidade estiver disponível, é adicionado a lista de compra
     * @param cadastroProdutoDTO
     * @return
     */
    public List<Produto> criarListaDeCompra(List<CadastroProdutoDTO> cadastroProdutoDTO ){

        List<Produto> listaProdutoCompra = new ArrayList<>();

        for (CadastroProdutoDTO produtoDTO : cadastroProdutoDTO) {
            for (Produto produto : listaProdutos){
                if (produto.getNome().equalsIgnoreCase(produtoDTO.getNome()) && atulizarProduto(produto)){
                    listaProdutoCompra.add(produto);
                }
            }
        }
        return listaProdutoCompra;
    }

    public boolean atulizarProduto(Produto produto){
        if (produto.getQuantidade() > 0){
            produto.setQuantidade( produto.getQuantidade() - 1 );
            return true;
        }

        throw new ExecaoProdutoEmFalta(produto.getNome());
    }
}

