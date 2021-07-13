package br.com.gomes.mercadolivretreino.service;

import br.com.gomes.mercadolivretreino.model.Produto;
import br.com.gomes.mercadolivretreino.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {

    @Autowired
    ProdutoRepository produtoRepository;

    public void salvarProduto(Produto produto) {
        produtoRepository.save(produto);
    }
}
