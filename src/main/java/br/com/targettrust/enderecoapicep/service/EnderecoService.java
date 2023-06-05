package br.com.targettrust.enderecoapicep.service;

import br.com.targettrust.enderecoapicep.model.Endereco;
import br.com.targettrust.enderecoapicep.repository.EnderecoRepository;
import br.com.targettrust.enderecoapicep.sistemaexterno.EnderecoApiClient;
import br.com.targettrust.enderecoapicep.sistemaexterno.EnderecoMapper;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnderecoService {
    private final EnderecoRepository enderecoRepository;
    private final EnderecoApiClient enderecoApiClient;

    public EnderecoService(EnderecoRepository enderecoRepository,
                           EnderecoApiClient enderecoApiClient) {
        this.enderecoRepository = enderecoRepository;
        this.enderecoApiClient = enderecoApiClient;
    }

    public List<Endereco> listarEndereco() {
        return enderecoRepository.findAll();
    }

    public void criar(Endereco endereco) {
        enderecoRepository.save(endereco);
    }

    public Endereco buscarEnderecoPorCep(String cep) {
//        var enderecoDto = enderecoApiClient.getEndereco(cep);
        var enderecoDto = enderecoApiClient.getEnderecoPorCep2(cep);
        return EnderecoMapper.toModel(enderecoDto);
    }

    public void criarPorCep(String cep) {
        Endereco endereco = buscarEnderecoPorCep(cep);
        criar(endereco);
    }
}
