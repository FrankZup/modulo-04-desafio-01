package br.com.zup.sistemaecommerce.controllers;

import br.com.zup.sistemaecommerce.DTOs.CadastroCompraDTO;
import br.com.zup.sistemaecommerce.models.Cliente;
import br.com.zup.sistemaecommerce.models.Compra;
import br.com.zup.sistemaecommerce.models.Produto;
import br.com.zup.sistemaecommerce.services.ClienteService;
import br.com.zup.sistemaecommerce.services.CompraService;
import br.com.zup.sistemaecommerce.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("compras/")
public class CompraController {

    @Autowired
    private CompraService compraService;

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private ProdutoService produtoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Compra registrarCompra(@RequestBody @Valid CadastroCompraDTO cadastroCompraDTO) {

        Cliente cliente = clienteService.pesquisarClientePeloCPF(cadastroCompraDTO.getCpf());

        List<Produto> listaDeProdutos = produtoService.criarListaDeCompra(
                cadastroCompraDTO.getProdutos());

        Compra compra = compraService.registrarCompra(cadastroCompraDTO.
                converterDTOparaCompra(cliente, listaDeProdutos));

        return compra;

    }

    @GetMapping
    public List<Compra> listarCompras() {
        return compraService.listarCompras();
    }

    @GetMapping("{cpf}/")
    public List <Compra> listarComprasPorCliente(@PathVariable String cpf) {
        return compraService.pesquisarCompraPeloCPFdoCliente(cpf);
    }

}

