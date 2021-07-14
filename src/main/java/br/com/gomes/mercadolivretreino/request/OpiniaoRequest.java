package br.com.gomes.mercadolivretreino.request;

import br.com.gomes.mercadolivretreino.model.Opiniao;
import br.com.gomes.mercadolivretreino.model.Produto;
import br.com.gomes.mercadolivretreino.model.Usuario;
import org.hibernate.validator.constraints.Length;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class OpiniaoRequest {

    @Min(value = 1, message = "Nota minima igual a 1")
    @Max(value = 5, message = "Nota máxima igual a 5")
    private Integer nota;
    @NotBlank(message = "Título não pode ser em branco, campo obrigatório!")
    private String titulo;
    @Length(max = 500)
    private String descricao;
    @NotNull
    private Long produtoId;

    @Deprecated
    public OpiniaoRequest() {

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

    public Long getProdutoId() {
        return produtoId;
    }

    public void setProdutoId(Long produtoId) {
        this.produtoId = produtoId;
    }

    public Opiniao toModel(Usuario usuario, Produto produto) {
        return new Opiniao(nota,titulo,descricao,usuario,produto);

    }
}
