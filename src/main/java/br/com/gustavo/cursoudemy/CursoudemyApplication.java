package br.com.gustavo.cursoudemy;



import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.gustavo.cursoudemy.domains.Categoria;
import br.com.gustavo.cursoudemy.domains.Produto;
import br.com.gustavo.cursoudemy.repositories.CategoriaRepository;
import br.com.gustavo.cursoudemy.repositories.ProdutoRepository;

@SpringBootApplication
public class CursoudemyApplication implements CommandLineRunner{
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CursoudemyApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria(null,"Escritorio");
		Categoria cat2 = new Categoria(null,"Informatica");
		
		Produto p1 = new Produto(null,"Impressora",2000.00);
		Produto p2 = new Produto(null,"Desktop",3000.00);
		Produto p3 = new Produto(null,"Mouse",50.00);
		
		cat1.getProdutos().addAll(Arrays.asList(p1));
		cat2.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		
		p1.getCategorias().addAll(Arrays.asList(cat1,cat2));
		p2.getCategorias().addAll(Arrays.asList(cat1));
		p3.getCategorias().addAll(Arrays.asList(cat2));
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3));
	}

}
