package br.com.gomes.mercadolivretreino.controller;

import br.com.gomes.mercadolivretreino.model.Categoria;
import br.com.gomes.mercadolivretreino.model.Produto;
import br.com.gomes.mercadolivretreino.model.Usuario;
import br.com.gomes.mercadolivretreino.request.ProdutoRequest;
import br.com.gomes.mercadolivretreino.request.UsuarioRequest;
import br.com.gomes.mercadolivretreino.response.ProdutoResponse;
import br.com.gomes.mercadolivretreino.response.UsuarioResponse;
import br.com.gomes.mercadolivretreino.service.CategoriaService;
import br.com.gomes.mercadolivretreino.service.ProdutoService;
import br.com.gomes.mercadolivretreino.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class ProdutoController {

    @Autowired
    ProdutoService produtoService;

    @Autowired
    CategoriaService categoriaService;

    @PostMapping("/produto")
    public ResponseEntity<ProdutoResponse> novoProduto(@Validated @RequestBody ProdutoRequest produtoRequest) {

        Produto produto = produtoRequest.toModel(
                categoriaService.buscarCategoria(
                        produtoRequest.getCategoria()
                )
        );
        produtoService.salvarProduto(produto);
        ProdutoResponse produtoResponse = produto.toResponse();
        return ResponseEntity.status(HttpStatus.OK).body(produtoResponse);


    }
}
