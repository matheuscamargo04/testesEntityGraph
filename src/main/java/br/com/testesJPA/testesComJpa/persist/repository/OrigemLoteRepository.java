package br.com.testesJPA.testesComJpa.persist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.testesJPA.testesComJpa.domain.entity.OrigemLote;

@Repository
public interface OrigemLoteRepository extends JpaRepository<OrigemLote, Long> {

}
