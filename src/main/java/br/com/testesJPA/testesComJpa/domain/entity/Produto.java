package br.com.testesJPA.testesComJpa.domain.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.NamedEntityGraphs;
import javax.persistence.NamedSubgraph;

import lombok.Data;

@NamedEntityGraphs({

		@NamedEntityGraph(name = "Produto.fetchSimples", attributeNodes = { @NamedAttributeNode("lote"),
				@NamedAttributeNode("fabrica") }),

		@NamedEntityGraph(name = "Produto.fetchDeeper", attributeNodes = {
				@NamedAttributeNode(value = "lote", subgraph = "loteSubgraph"),
				@NamedAttributeNode("fabrica") }, subgraphs = {
						@NamedSubgraph(name = "loteSubgraph", attributeNodes = { @NamedAttributeNode("origem"), }) }) })
@Entity
@Data
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	private String descricao;

	@ManyToOne
	private Lote lote;

	@ManyToOne
	private Fabrica fabrica;

}
