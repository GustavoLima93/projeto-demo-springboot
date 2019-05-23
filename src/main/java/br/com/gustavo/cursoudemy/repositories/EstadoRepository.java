package br.com.gustavo.cursoudemy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.gustavo.cursoudemy.domains.Estado;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Integer> {

}
