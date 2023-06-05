package br.com.targettrust.enderecoapicep.repository;

import br.com.targettrust.enderecoapicep.model.Casa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CasaRepository extends JpaRepository<Casa, Long> {

    @Query("select c from Casa c where c.id in (:ids)")
    List<Casa> findAllByIds(List<Long> ids);
}
