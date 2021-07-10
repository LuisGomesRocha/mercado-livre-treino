package br.com.gomes.mercadolivretreino.service;

import br.com.gomes.mercadolivretreino.model.Usuario;
import br.com.gomes.mercadolivretreino.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    public void salvarUsuario(Usuario usuario) {
        usuarioRepository.save(usuario);
    }
}
