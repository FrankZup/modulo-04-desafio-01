package br.com.zup.sistemaecommerce.exceptions;

import org.springframework.http.HttpStatus;

public class ExcecaoCompraNaoFinalizada extends Excecao {

    public ExcecaoCompraNaoFinalizada() {
        super("Cliente não finalizada!", HttpStatus.BAD_REQUEST, "cliente");
    }
}
