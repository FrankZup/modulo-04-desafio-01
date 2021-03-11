package br.com.zup.sistemaecommerce.services;

import br.com.zup.sistemaecommerce.exceptions.ExcecaoCompraNaoFinalizada;
import br.com.zup.sistemaecommerce.models.Compra;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Franklin Hanemann
 *  Classe que realiza todas as funcionalidades relacionadas a classe Compra:
 *        - Registrar Compra
 *        - Listar todas as compras
 *        - Pesquisar Compra pelo CPF do Cliente
 */
@Service
public class CompraService {

    private List<Compra> listaCompras = new ArrayList<>();

    public Compra registrarCompra(Compra compra){
        listaCompras.add(compra);
        return compra;
    }

    public List<Compra> listarCompras(){
        return listaCompras;
    }

    public List<Compra> pesquisarCompraPeloCPFdoCliente(String cpf){
        for (Compra objetoCompra: listaCompras){
            if (objetoCompra.getCliente().getCpf().equalsIgnoreCase(cpf)){
                listaCompras.add(objetoCompra);
            }
        }

        throw new ExcecaoCompraNaoFinalizada();
    }

}
