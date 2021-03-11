package br.com.zup.sistemaecommerce.exceptions;

import org.springframework.http.HttpStatus;

public class ExcecaoProdutoNaoEncontrado extends Excecao {
    public ExcecaoProdutoNaoEncontrado() {
        super("Cliente não cadastrado!", HttpStatus.BAD_REQUEST, "cliente");
    }
}

