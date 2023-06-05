package br.com.targettrust.enderecoapicep.model;

import java.time.LocalDate;

public class PessoaComEndereco {
    private String nome;
    private LocalDate dataNascimento;

    private Endereco endereco;

    public PessoaComEndereco(String nome, LocalDate dataNascimento, Endereco endereco) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public Endereco getEndereco() {
        return endereco;
    }
}
