package br.com.gomes.mercadolivretreino.repository;

import br.com.gomes.mercadolivretreino.model.Compra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompraRepository extends JpaRepository<Compra,Long> {


}
