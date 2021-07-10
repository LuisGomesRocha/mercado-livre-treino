package br.com.gomes.mercadolivretreino.repository;

import br.com.gomes.mercadolivretreino.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
