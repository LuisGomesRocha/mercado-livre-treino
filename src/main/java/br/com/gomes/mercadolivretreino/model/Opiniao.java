package br.com.gomes.mercadolivretreino.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Opiniao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Min(value = 1, message = "Nota minima igual a 1")
    @Max(value = 5, message = "Nota máxima igual a 5")
    private Integer nota;
    @NotBlank(message = "Título não pode ser em branco, campo obrigatório!")
    private String titulo;
    @Length(max = 500)
    private String descricao;
    @NotNull
    @ManyToOne
    @JsonIgnore
    private Usuario usuario;
    @NotNull
    @ManyToOne
    @JsonIgnore
    private Produto produto;


    public Opiniao(Integer nota, String titulo, String descricao, Usuario usuario, Produto produto) {
        this.nota = nota;
        this.titulo = titulo;
        this.descricao = descricao;
        this.usuario = usuario;
        this.produto = produto;
    }
@Deprecated
    public Opiniao(){
    }

    public Long getId() {
        return id;
    }

      public Integer getNota() {
        return nota;
    }

    public void setNota(Integer nota) {
        this.nota = nota;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
}
