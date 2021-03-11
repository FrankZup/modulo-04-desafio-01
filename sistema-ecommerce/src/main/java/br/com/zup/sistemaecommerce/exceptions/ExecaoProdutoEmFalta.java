package br.com.zup.sistemaecommerce.exceptions;

import org.springframework.http.HttpStatus;

public class ExecaoProdutoEmFalta extends Excecao {
    public ExecaoProdutoEmFalta(String nomeDoProduto) {
        super("Produto " + nomeDoProduto + " está em falta no estoque",
                HttpStatus.PRECONDITION_FAILED, "Validação");
    }
}