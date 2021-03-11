package br.com.zup.sistemaecommerce.exceptions;

import org.springframework.http.HttpStatus;

public class ExcecaoClienteDuplicado extends Excecao {
    public ExcecaoClienteDuplicado() {
        super("Cliente não cadastrado!",
                HttpStatus.BAD_REQUEST, "cliente");
    }

    public ExcecaoClienteDuplicado(String nomeCliente) {
        super("Cliente "+nomeCliente+ " já cadastrado!", HttpStatus.BAD_REQUEST,
              "cliente");

    }
}
