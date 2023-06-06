package br.com.targettrust.enderecoapicep.service;

import br.com.targettrust.enderecoapicep.model.Casa;
import br.com.targettrust.enderecoapicep.model.Endereco;
import br.com.targettrust.enderecoapicep.model.Pessoa;
import br.com.targettrust.enderecoapicep.repository.CasaRepository;
import br.com.targettrust.enderecoapicep.repository.EnderecoRepository;
import br.com.targettrust.enderecoapicep.repository.PessoaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaService {
    private final PessoaRepository pessoaRepository;
    private final EnderecoRepository enderecoRepository;
    private final CasaRepository casaRepository;

    public PessoaService(PessoaRepository pessoaRepository,
                         EnderecoRepository enderecoRepository,
                         CasaRepository casaRepository) {
        this.pessoaRepository = pessoaRepository;
        this.enderecoRepository = enderecoRepository;
        this.casaRepository = casaRepository;
    }

    public List<Pessoa> listar() {
        return pessoaRepository.findAll();
    }

    public void criar(Pessoa pessoa, List<Long> enderecoId) {

        List<Endereco> enderecos = enderecoRepository.findAllByIdsIn(enderecoId);
        if (enderecos.isEmpty()) {
            throw new RuntimeException("Endereço não existe");
        }

        enderecos.forEach(endereco -> {
            endereco.setPessoa(pessoa);
        });

        // aqui o jpa vai relacionar pessoa com o endereco de id enderecoId
        pessoa.setEndereco(enderecos);

        pessoaRepository.save(pessoa);
    }

    public void comprarCasas(Long pessoaId, List<Long> casasIds) {
        List<Casa> casas = casaRepository.findAllByIds(casasIds);
        if(casas.isEmpty()) {
            throw new RuntimeException("Casas não existem");
        }

        Pessoa pessoa = pessoaRepository.findById(pessoaId).orElseThrow(() -> new RuntimeException("Pessoa não existe"));

        pessoa.setCasas(casas);

        pessoaRepository.save(pessoa);

    }

    public List<Pessoa> findByNome(String nome) {
        return pessoaRepository.findByNomeIsLikeIgnoreCase("%" + nome + "%");
    }
}
