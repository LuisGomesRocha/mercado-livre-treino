package br.com.gomes.mercadolivretreino.request;

import br.com.gomes.mercadolivretreino.model.Usuario;

public class UsuarioRequest {

    private String login;
    private String senha;

    public Usuario toModel(){
        return new Usuario(this.login, this.senha);
    }
}
