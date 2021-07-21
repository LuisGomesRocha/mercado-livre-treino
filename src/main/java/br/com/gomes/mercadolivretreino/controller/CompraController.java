package br.com.gomes.mercadolivretreino.controller;

import br.com.gomes.mercadolivretreino.model.Compra;
import br.com.gomes.mercadolivretreino.model.Usuario;
import br.com.gomes.mercadolivretreino.request.CompraRequest;
import br.com.gomes.mercadolivretreino.service.CompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;


@RestController
@RequestMapping("/api/v1/compra")
public class CompraController {

    @Autowired
    CompraService compraService;


    @PostMapping
    public ResponseEntity novaCompraIniciada(@Validated @RequestBody CompraRequest compraRequest, HttpServletResponse httpServletResponse) throws IOException, URISyntaxException {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Usuario usuario = (Usuario) authentication.getPrincipal();
        SecurityContextHolder.getContext().getAuthentication().getCredentials();


        Compra compra = compraService.montarNovaCompra(compraRequest, usuario);
        compraService.salvar(compra);

        URI uri = new URI(compra.getPagamento().getUrl(compra.getId().toString()));
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setLocation(uri);

        return ResponseEntity.status(HttpStatus.FOUND).headers(httpHeaders).build();


    }
}
