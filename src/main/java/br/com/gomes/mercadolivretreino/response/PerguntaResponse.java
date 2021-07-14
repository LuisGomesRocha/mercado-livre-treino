package br.com.gomes.mercadolivretreino.response;

public class PerguntaResponse {
    private Long id;

    public PerguntaResponse(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
