package br.com.targettrust.enderecoapicep.controller.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;

public class CompraDTO {

    @NotNull
    private Long idPessoa;

    @NotNull
    @Size(min = 1)
    private List<Long> casasId;

    public Long getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(Long idPessoa) {
        this.idPessoa = idPessoa;
    }

    public List<Long> getCasasId() {
        return casasId;
    }

    public void setCasasId(List<Long> casasId) {
        this.casasId = casasId;
    }
}
