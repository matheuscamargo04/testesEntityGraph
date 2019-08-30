package br.com.testesJPA.testesComJpa;

import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.testesJPA.testesComJpa.domain.entity.Fabrica;
import br.com.testesJPA.testesComJpa.domain.entity.Lote;
import br.com.testesJPA.testesComJpa.domain.entity.OrigemLote;
import br.com.testesJPA.testesComJpa.domain.entity.Produto;
import br.com.testesJPA.testesComJpa.persist.repository.FabricaRepository;
import br.com.testesJPA.testesComJpa.persist.repository.LoteRepository;
import br.com.testesJPA.testesComJpa.persist.repository.OrigemLoteRepository;
import br.com.testesJPA.testesComJpa.persist.repository.ProdutoRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TestesComJpaApplicationTests {

	@Autowired
	private ProdutoRepository repository;

	@Autowired
	private LoteRepository loteRepository;

	@Autowired
	private OrigemLoteRepository origemRepository;

	@Autowired
	private FabricaRepository fabricaRepository;

	@Test
	public void testFindById() {

		Produto produto = popula();

		Optional<Produto> entity = repository.findById(produto.getId());
		Assert.assertTrue("TRUE", entity.isPresent());
	}

	@Test
	public void testFindByDescricao() {

		Produto produto = popula();

		Produto entity = repository.findByDescricao(produto.getDescricao());
		Assert.assertTrue(":ERROR:", entity != null);
	}

	@Test
	public void testFindByDescricaoFetchSimples() {

		Produto produto = popula();

		Produto entity = repository.findByDescricaoQueryEntityGraphSimples(produto.getDescricao());
		Assert.assertTrue(":ERROR:", entity != null);
	}

	@Test
	public void testFindByDescricaoFetchDeeper() {

		Produto produto = popula();

		Produto entity = repository.findByDescricaoQueryEntityGraphDeeper(produto.getDescricao());
		Assert.assertTrue(":ERROR:", entity != null);
	}

	private Produto popula() {

		Lote lote = new Lote();
		Fabrica fabrica = new Fabrica();
		OrigemLote origem = new OrigemLote();

		origem.setEnderecoOrigemLote("Campinas");
		lote.setDescricao("Eletronicos");
		lote.setOrigem(origem);

		fabrica.setNomeFabrica("Samsung");

		Produto produto = new Produto();
		produto.setDescricao("Celular");
		produto.setLote(lote);
		produto.setFabrica(fabrica);

		origemRepository.save(origem);
		fabricaRepository.save(fabrica);
		loteRepository.save(lote);
		repository.save(produto);
		return produto;
	}
}
