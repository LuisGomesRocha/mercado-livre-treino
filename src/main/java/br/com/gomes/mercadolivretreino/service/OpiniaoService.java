package br.com.gomes.mercadolivretreino.service;

import br.com.gomes.mercadolivretreino.model.Opiniao;
import br.com.gomes.mercadolivretreino.model.Produto;
import br.com.gomes.mercadolivretreino.model.Usuario;
import br.com.gomes.mercadolivretreino.repository.OpiniaoRepository;
import br.com.gomes.mercadolivretreino.request.OpiniaoRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class OpiniaoService {

    @Autowired
    private ProdutoService produtoService;

    @Autowired
    private OpiniaoRepository opiniaoRepository;



    public Long salvarOpiniao(Usuario usuario, OpiniaoRequest opiniaoRequest) {

        Produto produto = produtoService.procurarProduto(opiniaoRequest.getProdutoId());
        Opiniao opiniao = opiniaoRequest.toModel(usuario, produto);
        produto.getOpinioes().add(opiniao);
        usuario.getOpinioes().add(opiniao);
        return opiniaoRepository.save(opiniao).getId();

    }

}
