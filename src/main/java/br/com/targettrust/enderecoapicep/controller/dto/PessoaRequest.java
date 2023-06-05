package br.com.targettrust.enderecoapicep.controller.dto;

import jakarta.validation.constraints.*;

import java.time.LocalDate;
import java.util.List;

public class PessoaRequest {

    @NotBlank
    private String nome;

    @PastOrPresent
    private LocalDate dataNascimento;

    @NotNull
    @Size(min = 1)
    private List<Long> enderecoId;

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

    public List<Long> getEnderecoId() {
        return enderecoId;
    }

    public void setEnderecoId(List<Long> enderecoId) {
        this.enderecoId = enderecoId;
    }
}
