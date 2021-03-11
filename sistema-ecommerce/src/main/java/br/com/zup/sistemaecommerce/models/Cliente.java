package br.com.zup.sistemaecommerce.models;

import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Cliente {
    @NotNull
    @Size(min=3, max=30)
    private String nome;
    @CPF(message = "CPF invalido")
    private String cpf;
    @Email(message = "E-mail invalido")
    private String email;

    public Cliente() {}

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}
