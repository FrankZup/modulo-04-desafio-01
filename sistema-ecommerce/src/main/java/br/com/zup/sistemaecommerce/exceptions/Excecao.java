package br.com.zup.sistemaecommerce.exceptions;

import org.springframework.http.HttpStatus;

public class Excecao extends RuntimeException {
    private HttpStatus status;
    private String tipoErro;

    public Excecao(String mensagem, HttpStatus status, String tipoErro) {
        super(mensagem);
        this.status   = status;
        this.tipoErro = tipoErro;
    }

    public HttpStatus getStatus() { return status;  }
    public void setStatus(HttpStatus status) { this.status = status; }

    public String getTipoErro() { return tipoErro; }
    public void setTipoErro(String tipoErro) { this.tipoErro = tipoErro; }
}
