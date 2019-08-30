package br.com.testesJPA.testesComJpa.persist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.testesJPA.testesComJpa.domain.entity.Fabrica;

@Repository
public interface FabricaRepository extends JpaRepository<Fabrica, Long> {

}
