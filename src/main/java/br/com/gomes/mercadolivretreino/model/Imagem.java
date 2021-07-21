package br.com.gomes.mercadolivretreino.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Imagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(columnDefinition = "TEXT")
    private String imagem;
    @ManyToOne
    @JsonIgnore
    private Produto produto;

    public Imagem(Long id, String imagem, Produto produto) {
        this.id = id;
        this.imagem = imagem;
        this.produto = produto;
    }

    @Deprecated
    public Imagem(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
}
