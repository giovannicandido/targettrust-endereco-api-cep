package br.com.targettrust.enderecoapicep.controller.mapper;

import br.com.targettrust.enderecoapicep.controller.dto.PessoaRequest;
import br.com.targettrust.enderecoapicep.controller.dto.PessoaResponse;
import br.com.targettrust.enderecoapicep.model.Pessoa;

public class PessoaMapper {
    public static Pessoa toModel(PessoaRequest request) {
        Pessoa pessoa = new Pessoa();
        pessoa.setNome(request.getNome());
        pessoa.setDataNascimento(request.getDataNascimento());
        return pessoa;
    }

    public static PessoaResponse toResponse(Pessoa pessoa) {
        PessoaResponse response = new PessoaResponse();
        response.setNome(pessoa.getNome());
        response.setDataNascimento(pessoa.getDataNascimento());
        return response;
    }
}
