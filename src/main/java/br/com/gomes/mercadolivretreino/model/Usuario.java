package br.com.gomes.mercadolivretreino.model;

import br.com.gomes.mercadolivretreino.response.UsuarioResponse;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Login não deve ser branco!")
    @Size(min = 3, max = 30, message = "Login deve conter de 3 a 30 caracteres!")
    private String login;
    @Size(min = 6, message = "Senha precisa ter no mínimo 6 caracteres!")
    @NotBlank(message = "Senha em branco!")
    private String senha;
    private LocalDateTime localDateTime = LocalDateTime.now();


    @Deprecated
    public Usuario(){
    }

    public Usuario(String login, String senha) {
        this.login = login;
        this.senha = senha;
    }

    public UsuarioResponse toResponse() {
        return new UsuarioResponse(this.id, this.login);
    }
}
