package br.com.zup.sistemaecommerce.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ManipuladorExcecao extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers,
                                                                  HttpStatus status,
                                                                  WebRequest request) {
        List <Erro> erros = criarListaDeErros(ex);
        RespostaErro resposta = new RespostaErro("validacao", status, erros);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(resposta);
    }

    @ExceptionHandler(Excecao.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity <RespostaErro> manipularErros(Excecao excecao) {
        RespostaErro resposta = RespostaErro.criarErro(excecao);
        return ResponseEntity.status(resposta.getStatusErro()).body(resposta);
    }

    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex,
                                                             Object body,
                                                             HttpHeaders headers,
                                                             HttpStatus status,
                                                             WebRequest request) {
        return super.handleExceptionInternal(ex, body, headers, status, request);
    }

    private List <Erro> criarListaDeErros(MethodArgumentNotValidException excecao) {
        List<Erro> erros = new ArrayList<>();

        for (FieldError erro: excecao.getFieldErrors()) {
            erros.add(new Erro(erro.getField(), erro.getDefaultMessage()));
        }

        return erros;
    }

}

