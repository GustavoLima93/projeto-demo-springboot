package br.com.gustavo.cursoudemy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.gustavo.cursoudemy.domains.Cidade;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Integer> {

}
