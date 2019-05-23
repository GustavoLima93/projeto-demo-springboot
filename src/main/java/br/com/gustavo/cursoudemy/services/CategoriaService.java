package br.com.gustavo.cursoudemy.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gustavo.cursoudemy.domains.Categoria;
import br.com.gustavo.cursoudemy.repositories.CategoriaRepository;
import br.com.gustavo.cursoudemy.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository repo;
	
	public Categoria buscar(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
		
	}
	
	public List<Categoria> getAll() {
		List<Categoria> obj = repo.findAll();
		return obj;
		
	}
	
	
}
