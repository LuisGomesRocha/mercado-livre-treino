package br.com.gomes.mercadolivretreino.request;

import br.com.gomes.mercadolivretreino.model.Pergunta;
import br.com.gomes.mercadolivretreino.model.Produto;
import br.com.gomes.mercadolivretreino.model.Usuario;

import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class PerguntaRequest {

    @NotBlank
    private String titulo;
    @NotNull
    private Long idProduto;

    public PerguntaRequest(String titulo, Long idProduto) {
        this.titulo = titulo;
        this.idProduto = idProduto;
    }

    @Deprecated
    public PerguntaRequest() {
    }

    public Pergunta toModel(Usuario usuario, Produto produto) {
        return new Pergunta(this.titulo, usuario, produto);
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Long getIdProduto() {
        return idProduto;
    }

    public void setProduto(Long idProduto) {
        this.idProduto = idProduto;
    }
}
