package br.com.gomes.mercadolivretreino.repository;

import br.com.gomes.mercadolivretreino.model.Pergunta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PerguntaRepository extends JpaRepository<Pergunta,Long> {
}
