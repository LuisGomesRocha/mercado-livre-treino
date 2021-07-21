package br.com.gomes.mercadolivretreino.controller;

import br.com.gomes.mercadolivretreino.model.Usuario;
import br.com.gomes.mercadolivretreino.request.CompraConfirmadaRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URISyntaxException;

@RestController
@RequestMapping("/api/v1/pagamento-confirmado")
public class PagamentoConfirmadoController {

    @PostMapping
    public ResponseEntity novaCompraIniciada(@Validated @RequestBody CompraConfirmadaRequest request, @RequestParam String provedor) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Usuario usuario = (Usuario) authentication.getPrincipal();
        SecurityContextHolder.getContext().getAuthentication().getCredentials();

        return null;
    }
}