package br.com.gomes.mercadolivretreino.request;

public class CompraConfirmadaRequest {

    private Long idOrigem;
    private Long idPagamentoProvedor;
    private String status;

    @Deprecated
    public CompraConfirmadaRequest(){
    }

    public Long getIdOrigem() {
        return idOrigem;
    }

    public void setIdOrigem(Long idOrigem) {
        this.idOrigem = idOrigem;
    }

    public Long getIdPagamentoProvedor() {
        return idPagamentoProvedor;
    }

    public void setIdPagamentoProvedor(Long idPagamentoProvedor) {
        this.idPagamentoProvedor = idPagamentoProvedor;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
