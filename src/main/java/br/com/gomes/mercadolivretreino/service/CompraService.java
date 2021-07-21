package br.com.gomes.mercadolivretreino.service;

import br.com.gomes.mercadolivretreino.config.exception.ApiErrorException;
import br.com.gomes.mercadolivretreino.model.Compra;
import br.com.gomes.mercadolivretreino.model.Gateway;
import br.com.gomes.mercadolivretreino.model.Produto;
import br.com.gomes.mercadolivretreino.model.Usuario;
import br.com.gomes.mercadolivretreino.repository.CompraRepository;
import br.com.gomes.mercadolivretreino.request.CompraRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class CompraService {

    @Autowired
    private CompraRepository compraRepository;

    @Autowired
    private ProdutoService produtoService;

    public void salvar(Compra compra) {
        produtoService.decrementarEstoqueDoProduto(compra.getProduto(), compra.getQuantidade());
        compraRepository.save(compra);
    }

    public Compra montarNovaCompra(CompraRequest request, Usuario comprador) {
        Compra compra = new Compra();
        Produto produto = produtoService.procurarProduto(request.getIdProduto());

        if (produtoService.existeQuantidadeDisponivel(produto, request.getQuantidade())) {
            throw new ApiErrorException(HttpStatus.INSUFFICIENT_STORAGE, "Quantidade insuficiente.");
        }

        compra.setPagamento(busca(request.getGateway()));
        compra.setProduto(produto);
        compra.setQuantidade(request.getQuantidade());
        compra.setComprador(comprador);
        compra.setValorProduto(produto.getValor());

        return compra;
    }

    public Gateway busca(String gateway) {
        return Arrays.stream(Gateway.values())
                .filter(enumGateway -> gateway.equalsIgnoreCase(enumGateway.toString()))
                .findFirst()
                .orElseThrow(() -> new ApiErrorException(HttpStatus.BAD_REQUEST, "Metodo de pagamento nao aceito"));
    }

    public void defineUrlResposta() {

//
//        paypal.com ? buyerId = {idGeradoDaCompra} & redirectUrl = {urlRetornoAppPosPagamento}
//
//        String baseUri = "paypal.com?"
//        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl();
//        builder.queryParam("id", "1");
//        String uri = builder.build().encode().toUriString();
//
//
//        pagseguro.com ? returnId = {idGeradoDaCompra} & redirectUrl = {urlRetornoAppPosPagamento}
//        String baseUri = "/sample-uri"
//        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(uri);
//        builder.queryParam("id", "1");
//        String uri = builder.build().encode().toUriString();

    }

}
