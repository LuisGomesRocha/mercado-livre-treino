package br.com.gomes.mercadolivretreino.request;

public class CompraRequest {

    private Long idProduto;
    private Integer quantidade;
    private String  gateway;

    public CompraRequest(Long idProduto, Integer quantidade, String gateway) {
        this.idProduto = idProduto;
        this.quantidade = quantidade;
        this.gateway = gateway;
    }

    public Long getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Long idProduto) {
        this.idProduto = idProduto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public String getGateway() {
        return gateway;
    }

    public void setGateway(String gateway) {
        this.gateway = gateway;
    }
}
