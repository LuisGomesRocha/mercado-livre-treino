package br.com.gomes.mercadolivretreino.response;

import br.com.gomes.mercadolivretreino.model.Caracteristica;
import br.com.gomes.mercadolivretreino.model.Imagem;
import br.com.gomes.mercadolivretreino.model.Opiniao;
import br.com.gomes.mercadolivretreino.model.Pergunta;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.math.BigDecimal;
import java.util.List;

public class DetalheResponse {

    private List<Imagem> imagens;
    private String nome;
    private BigDecimal preco;
    private List<Caracteristica> caracteristicas;
    private String descricao;
    private Double mediaNotas;
    private Integer totalNotas;
    private List<Opiniao> opinioes;
    private List<Pergunta> perguntas;

    @Deprecated
    public DetalheResponse() {
    }

    public List<Imagem> getImagens() {
        return imagens;
    }

    public void setImagens(List<Imagem> imagens) {
        this.imagens = imagens;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public List<Caracteristica> getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(List<Caracteristica> caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getMediaNotas() {
        return mediaNotas;
    }

    public void setMediaNotas(Double mediaNotas) {
        this.mediaNotas = mediaNotas;
    }

    public Integer getTotalNotas() {
        return totalNotas;
    }

    public void setTotalNotas(Integer totalNotas) {
        this.totalNotas = totalNotas;
    }

    public List<Opiniao> getOpinioes() {
        return opinioes;
    }

    public void setOpinioes(List<Opiniao> opinioes) {
        this.opinioes = opinioes;
    }

    public List<Pergunta> getPerguntas() {
        return perguntas;
    }

    public void setPerguntas(List<Pergunta> perguntas) {
        this.perguntas = perguntas;
    }
}


