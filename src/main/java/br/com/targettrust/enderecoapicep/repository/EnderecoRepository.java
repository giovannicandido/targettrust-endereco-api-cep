package br.com.targettrust.enderecoapicep.repository;

import br.com.targettrust.enderecoapicep.model.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

    @Query("select e from Endereco e where e.id in (:ids) ")
    List<Endereco> findAllByIdsIn(List<Long> ids);
}
