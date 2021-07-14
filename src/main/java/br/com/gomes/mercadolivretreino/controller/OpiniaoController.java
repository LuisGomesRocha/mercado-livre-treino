package br.com.gomes.mercadolivretreino.controller;

import br.com.gomes.mercadolivretreino.model.Produto;
import br.com.gomes.mercadolivretreino.model.Usuario;
import br.com.gomes.mercadolivretreino.request.OpiniaoRequest;
import br.com.gomes.mercadolivretreino.request.ProdutoRequest;
import br.com.gomes.mercadolivretreino.response.OpiniaoResponse;
import br.com.gomes.mercadolivretreino.response.ProdutoResponse;
import br.com.gomes.mercadolivretreino.service.CategoriaService;
import br.com.gomes.mercadolivretreino.service.OpiniaoService;
import br.com.gomes.mercadolivretreino.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/api/v1/opiniao")
public class OpiniaoController {

    @Autowired
   private OpiniaoService opinaoService;

    @PostMapping
    public ResponseEntity<OpiniaoResponse> novaOpiniao(@Validated @RequestBody OpiniaoRequest opiniaoRequest) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Usuario usuario = (Usuario) authentication.getPrincipal();
        SecurityContextHolder.getContext().getAuthentication().getCredentials();

        Long retorno = opinaoService.salvarOpiniao(usuario,opiniaoRequest);
        OpiniaoResponse opiniaoResponse = new OpiniaoResponse(retorno);
        return ResponseEntity.status(HttpStatus.OK).body(opiniaoResponse);
    }
}
