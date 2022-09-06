package br.edu.ifms.denatran.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ifms.denatran.model.Carro;

@Repository
public interface CarroRepository extends JpaRepository<Carro, Integer>{

	
}
