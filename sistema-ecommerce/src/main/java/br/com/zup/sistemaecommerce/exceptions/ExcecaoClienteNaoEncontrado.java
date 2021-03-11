package br.com.zup.sistemaecommerce.exceptions;

import org.springframework.http.HttpStatus;

public class ExcecaoClienteNaoEncontrado extends Excecao {
    public ExcecaoClienteNaoEncontrado() {
        super("Cliente não cadastrado!", HttpStatus.BAD_REQUEST, "cliente");
    }
}
