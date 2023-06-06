package br.com.targettrust.enderecoapicep.repository;

import br.com.targettrust.enderecoapicep.model.Pessoa;
import br.com.targettrust.enderecoapicep.model.PessoaComEndereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

    @Query("select new br.com.targettrust.enderecoapicep.model.PessoaComEndereco(p.nome, p.dataNascimento, p.endereco) from Pessoa p join p.endereco")
    List<PessoaComEndereco> findAllComEndereco();

    List<Pessoa> findByNomeIsLikeIgnoreCase(String nome);
}
