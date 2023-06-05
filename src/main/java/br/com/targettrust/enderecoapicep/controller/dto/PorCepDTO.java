package br.com.targettrust.enderecoapicep.controller.dto;

import jakarta.validation.constraints.NotBlank;

public class PorCepDTO {

    @NotBlank
    private String cep;

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }
}
