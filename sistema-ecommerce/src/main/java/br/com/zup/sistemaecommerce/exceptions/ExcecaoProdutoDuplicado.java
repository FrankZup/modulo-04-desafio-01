package br.com.zup.sistemaecommerce.exceptions;

import org.springframework.http.HttpStatus;

public class ExcecaoProdutoDuplicado extends Excecao {

    public ExcecaoProdutoDuplicado() {
        super("Cliente não cadastrado!", HttpStatus.BAD_REQUEST, "cliente");
    }

    public ExcecaoProdutoDuplicado(String nomeProduto) {
        super("Produto "+nomeProduto+ " já cadastrado!", HttpStatus.BAD_REQUEST, "cliente");

    }
}
