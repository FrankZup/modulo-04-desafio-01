package br.com.zup.sistemaecommerce.controllers;

import br.com.zup.sistemaecommerce.models.Cliente;
import br.com.zup.sistemaecommerce.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("clientes/")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente cadastrarCliente(@RequestBody @Valid Cliente cliente) {
        return clienteService.cadastrarCliente(cliente);
    }

    @GetMapping("{cpf}/")
    public Cliente pesquisarClientePeloCPF(@PathVariable String cpf){
        return clienteService.pesquisarClientePeloCPF(cpf);
    }

    @GetMapping
    public List<Cliente> pesquisarClientes() {
        return clienteService.listarClientes();
    }

}
