package br.com.gomes.mercadolivretreino.model;

public enum Gateway {

    PAYPAL("https://paypal.com?buyerId=%s&redirectUrl=%s"),
    PAGSEGURO("https://pagseguro.com?returnId=%s&redirectUrl=%s");


    private String url;

    Gateway(String url) {
        this.url = url;
    }


    public String getUrl(String returnId) {
        String redirectUrl = String.format("/api/v1/pagamento-confirmado?provedor=%s", this.toString().toLowerCase());
        return String.format(url, returnId, redirectUrl);
    }
}
