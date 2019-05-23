package br.com.gustavo.cursoudemy;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.gustavo.cursoudemy.domains.Categoria;
import br.com.gustavo.cursoudemy.domains.Cidade;
import br.com.gustavo.cursoudemy.domains.Cliente;
import br.com.gustavo.cursoudemy.domains.Endereco;
import br.com.gustavo.cursoudemy.domains.Estado;
import br.com.gustavo.cursoudemy.domains.Produto;
import br.com.gustavo.cursoudemy.domains.enums.TipoCliente;
import br.com.gustavo.cursoudemy.repositories.CategoriaRepository;
import br.com.gustavo.cursoudemy.repositories.CidadeRepository;
import br.com.gustavo.cursoudemy.repositories.ClienteRepository;
import br.com.gustavo.cursoudemy.repositories.EnderecoRepository;
import br.com.gustavo.cursoudemy.repositories.EstadoRepository;
import br.com.gustavo.cursoudemy.repositories.ProdutoRepository;

@SpringBootApplication
public class CursoudemyApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Autowired
	private ProdutoRepository produtoRepository;

	@Autowired
	private EstadoRepository estadoRepository;

	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;

	public static void main(String[] args) {
		SpringApplication.run(CursoudemyApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Categoria cat1 = new Categoria(null, "Escritorio");
		Categoria cat2 = new Categoria(null, "Informatica");

		Produto p1 = new Produto(null, "Impressora", 2000.00);
		Produto p2 = new Produto(null, "Desktop", 3000.00);
		Produto p3 = new Produto(null, "Mouse", 50.00);

		cat1.getProdutos().addAll(Arrays.asList(p1));
		cat2.getProdutos().addAll(Arrays.asList(p1, p2, p3));

		p1.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p2.getCategorias().addAll(Arrays.asList(cat2));
		p3.getCategorias().addAll(Arrays.asList(cat2));

		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3));

		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "Sao Paulo");

		Cidade cid1 = new Cidade(null, "Uberlandia", est1);
		Cidade cid2 = new Cidade(null, "Sao Paulo", est2);
		Cidade cid3 = new Cidade(null, "Campinas", est2);

		est1.getCidades().addAll(Arrays.asList(cid1));
		est2.getCidades().addAll(Arrays.asList(cid2, cid3));

		estadoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeRepository.saveAll(Arrays.asList(cid1, cid2, cid3));
		
		Cliente cli1 = new Cliente(null, "Maria Silva", "maria@gmail.com", "36378912377", TipoCliente.PESSOAFISICA);
		
		cli1.getTelefones().addAll(Arrays.asList("27363323", "93838393"));
		
		Endereco e1 = new Endereco(null, "Rua Flores", "300", "Apto 303", "Jardim", "38220834", cli1, cid1);
		Endereco e2 = new Endereco(null, "Avenida Matos", "105", "Sala 800", "Centro", "38777012", cli1, cid2);
		
		cli1.getEnderecos().addAll(Arrays.asList(e1, e2));
		
		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(e1,e2));
	}

}
