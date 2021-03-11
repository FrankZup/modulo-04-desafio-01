package br.com.zup.sistemaecommerce.exceptions;

import org.springframework.http.HttpStatus;

import java.util.Arrays;
import java.util.List;

public class RespostaErro {
    private String tipoErro;
    private HttpStatus statusErro;
    private List<Erro> listaErros;

    public RespostaErro() { }

    public RespostaErro(String tipoErro, HttpStatus statusErro, List<Erro> listaErros) {
        this.tipoErro   = tipoErro;
        this.statusErro = statusErro;
        this.listaErros = listaErros;
    }

    public String getTipoErro() { return tipoErro; }
    public void setTipoErro(String tipoErro) { this.tipoErro = tipoErro; }

    public HttpStatus getStatusErro() { return statusErro; }
    public void setStatus(HttpStatus statusErro) { this.statusErro = statusErro; }

    public List<Erro> getListaErros() {
        return listaErros;
    }
    public void setListaErros(List<Erro> listaErros) {
        this.listaErros = listaErros;
    }

    public static RespostaErro criarErro(Excecao excecao) {
        return new RespostaErro(excecao.getTipoErro(), excecao.getStatus(),
                Arrays.asList(new Erro(null, excecao.getMessage())));
    }
}

