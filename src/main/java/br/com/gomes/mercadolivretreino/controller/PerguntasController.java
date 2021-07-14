package br.com.gomes.mercadolivretreino.controller;

import br.com.gomes.mercadolivretreino.model.Usuario;
import br.com.gomes.mercadolivretreino.request.OpiniaoRequest;
import br.com.gomes.mercadolivretreino.request.PerguntaRequest;
import br.com.gomes.mercadolivretreino.response.OpiniaoResponse;
import br.com.gomes.mercadolivretreino.response.PerguntaResponse;
import br.com.gomes.mercadolivretreino.service.OpiniaoService;
import br.com.gomes.mercadolivretreino.service.PerguntaService;
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
@RequestMapping("/api/v1/pergunta")
public class PerguntasController {

    @Autowired
    private PerguntaService perguntaService;

    @PostMapping
    public ResponseEntity<PerguntaResponse> novaPergunta(@Validated @RequestBody PerguntaRequest perguntaRequest) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Usuario usuario = (Usuario) authentication.getPrincipal();
        SecurityContextHolder.getContext().getAuthentication().getCredentials();

        Long retorno = perguntaService.salvarPergunta(usuario, perguntaRequest);
        PerguntaResponse perguntaResponse = new PerguntaResponse(retorno);
        return ResponseEntity.status(HttpStatus.OK).body(perguntaResponse);
    }
}



