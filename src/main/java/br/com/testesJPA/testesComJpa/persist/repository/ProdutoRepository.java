package br.com.testesJPA.testesComJpa.persist.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.EntityGraph.EntityGraphType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.testesJPA.testesComJpa.domain.entity.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

	public Produto findByDescricao(String descricao);

	@Query(value = "SELECT p FROM Produto p WHERE p.descricao = ?1")
	@EntityGraph(value = "Produto.fetchSimples", type = EntityGraphType.LOAD)
	public Produto findByDescricaoQueryEntityGraphSimples(String descricao);

	@Query(value = "SELECT p FROM Produto p WHERE p.descricao = ?1")
	@EntityGraph(value = "Produto.fetchDeeper", type = EntityGraphType.LOAD)
	public Produto findByDescricaoQueryEntityGraphDeeper(String descricao);

}
