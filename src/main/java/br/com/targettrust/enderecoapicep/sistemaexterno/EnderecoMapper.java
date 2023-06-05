package br.com.targettrust.enderecoapicep.sistemaexterno;

import br.com.targettrust.enderecoapicep.model.Endereco;

public class EnderecoMapper {
    public static Endereco toModel(EnderecoDTO enderecoDTO) {
        var endereco = new Endereco();
        endereco.setCep(enderecoDTO.getCep());
        endereco.setBairro(enderecoDTO.getBairro());
        endereco.setDdd(enderecoDTO.getDdd());
        endereco.setIbge(enderecoDTO.getIbge());
        endereco.setComplemento(enderecoDTO.getComplemento());
        endereco.setLocalidade(enderecoDTO.getLocalidade());
        endereco.setLogradouro(enderecoDTO.getLogradouro());
        endereco.setUf(enderecoDTO.getUf());
        return endereco;
    }
}
