package br.com.zup.sistemaecommerce.services;
import br.com.zup.sistemaecommerce.exceptions.ExcecaoClienteDuplicado;
import br.com.zup.sistemaecommerce.exceptions.ExcecaoClienteNaoEncontrado;
import br.com.zup.sistemaecommerce.models.Cliente;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Franklin Hanemann
 * Classe que realiza todas as funcionalidades relacionadas a classe Cliente:
 *      - Cadastrar Cliente (com validação de cliente com CPF ja cadastrado)
 *      - Pesquisar Cliente pelo CPF
 *      - Pesquisar Cliente
 *
 */
@Service
public class ClienteService {

    private List<Cliente> listaClientes = new ArrayList<>();

    public Cliente cadastrarCliente(Cliente cliente){
        try {
            pesquisarCliente(cliente);
        } catch (RuntimeException erro){
            listaClientes.add(cliente);
            return cliente;
        }
        throw new ExcecaoClienteDuplicado(cliente.getCpf());
        
    }

    public Cliente pesquisarClientePeloCPF(String cpf){
        for (Cliente objetoCliente : listaClientes){
            if (objetoCliente.getCpf().equalsIgnoreCase(cpf)){
                return objetoCliente;
            }
        }

        throw new ExcecaoClienteNaoEncontrado();
    }

    public Cliente pesquisarCliente(Cliente cliente){
        return pesquisarClientePeloCPF(cliente.getCpf());
    }

    public List<Cliente> listarClientes(){
        return listaClientes;
    }
}

