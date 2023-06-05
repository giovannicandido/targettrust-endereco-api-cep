package br.com.targettrust.enderecoapicep.controller.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class PessoaResponse {
    private String nome;
    private LocalDate dataNascimento;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
}
