package br.com.gomes.mercadolivretreino.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

@Entity
public class Compra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private Status status = Status.INICIADA;
    private Gateway pagamento;
    @ManyToOne
    @JoinColumn(name = "id_produto")
    private Produto produto;
    @NotNull
    @Positive
    private Integer quantidade;
    @ManyToOne
    @JoinColumn(name = "id_comprador")
    private Usuario comprador;
    private BigDecimal valorProduto;

    //@Deprecated
    public Compra() {
    }

    public Compra(Gateway pagamento, Produto produto, Integer quantidade, Usuario comprador, BigDecimal valorProduto) {
        this.pagamento = pagamento;
        this.produto = produto;
        this.quantidade = quantidade;
        this.comprador = comprador;
        this.valorProduto = valorProduto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Gateway getPagamento() {
        return pagamento;
    }

    public void setPagamento(Gateway pagamento) {
        this.pagamento = pagamento;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Usuario getComprador() {
        return comprador;
    }

    public void setComprador(Usuario comprador) {
        this.comprador = comprador;
    }

    public BigDecimal getValorProduto() {
        return valorProduto;
    }

    public void setValorProduto(BigDecimal valorProduto) {
        this.valorProduto = valorProduto;
    }


}
