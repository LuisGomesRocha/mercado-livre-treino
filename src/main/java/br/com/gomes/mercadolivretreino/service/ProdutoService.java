package br.com.gomes.mercadolivretreino.service;

import br.com.gomes.mercadolivretreino.config.exception.ApiErrorException;
import br.com.gomes.mercadolivretreino.model.Imagem;
import br.com.gomes.mercadolivretreino.model.Produto;
import br.com.gomes.mercadolivretreino.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    ProdutoRepository produtoRepository;

    public void salvarProduto(Produto produto) {
        produto.getCaracteristicas().forEach(categoria -> categoria.setProduto(produto)); // Israel :D
        produtoRepository.save(produto);
    }

    public void salvarImagem(Produto produto, MultipartFile imagem) throws IOException {
        Imagem figura = new Imagem(null,imagem.getBytes(),produto);

        produto.getImagens().add(figura);
        produtoRepository.save(produto);
    }

    public Produto procurarProduto(Long produtoId)  {
       List<Produto> listaProduto = produtoRepository.findAllById(List.of(produtoId));

       if(listaProduto.size() == 0){
           throw new ApiErrorException(HttpStatus.NOT_FOUND, "Produto não encontrado!");

       }

       return listaProduto.get(0);

    }
}
