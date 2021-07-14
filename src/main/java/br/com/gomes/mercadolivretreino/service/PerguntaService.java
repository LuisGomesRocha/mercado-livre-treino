package br.com.gomes.mercadolivretreino.service;

import br.com.gomes.mercadolivretreino.model.Pergunta;
import br.com.gomes.mercadolivretreino.model.Produto;
import br.com.gomes.mercadolivretreino.model.Usuario;
import br.com.gomes.mercadolivretreino.repository.PerguntaRepository;
import br.com.gomes.mercadolivretreino.request.PerguntaRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PerguntaService {

    @Autowired
    ProdutoService produtoService;

    @Autowired
    PerguntaRepository perguntaRepository;


    public Long salvarPergunta(Usuario usuario, PerguntaRequest perguntaRequest) {


        Produto produto = produtoService.procurarProduto(perguntaRequest.getIdProduto());
        Pergunta pergunta = perguntaRequest.toModel(usuario, produto);
        produto.getPerguntas().add(pergunta);
        usuario.getPerguntas().add(pergunta);
        return perguntaRepository.save(pergunta).getId();

    }
}
