package br.com.zup.sistemaecommerce.exceptions;

import org.springframework.http.HttpStatus;

public class ExcecaoListaDeProdutosVazia extends Excecao {
    public ExcecaoListaDeProdutosVazia() {
        super("Produto não encontrado no estoque!", HttpStatus.BAD_REQUEST, "cliente");
    }
}
