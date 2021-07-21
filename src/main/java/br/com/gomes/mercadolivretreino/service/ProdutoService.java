package br.com.gomes.mercadolivretreino.service;

import br.com.gomes.mercadolivretreino.config.exception.ApiErrorException;
import br.com.gomes.mercadolivretreino.model.Imagem;
import br.com.gomes.mercadolivretreino.model.Opiniao;
import br.com.gomes.mercadolivretreino.model.Produto;
import br.com.gomes.mercadolivretreino.repository.ProdutoRepository;
import br.com.gomes.mercadolivretreino.response.DetalheResponse;
import org.apache.tomcat.util.codec.binary.Base64;
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

    public void salvarImagem(Produto produto, String imagem) throws IOException {
        Imagem figura = new Imagem(null, imagem, produto);

        produto.getImagens().add(figura);
        produtoRepository.save(produto);
    }

    public Produto procurarProduto(Long produtoId) {
        List<Produto> listaProduto = produtoRepository.findAllById(List.of(produtoId));

        if (listaProduto.size() == 0) {
            throw new ApiErrorException(HttpStatus.NOT_FOUND, "Produto não encontrado!");

        }

        return listaProduto.get(0);

    }

    public boolean existeQuantidadeDisponivel(Produto produto, Integer quantidade){
        if (produto.getQuantidade() < quantidade){
            return true;
        }
        return false;
    }

    public void decrementarEstoqueDoProduto(Produto produto, Integer quantidade){
        produto.setQuantidade(produto.getQuantidade() - quantidade);
    }

    public DetalheResponse exibeDetalhes(Long idProduto) {

        DetalheResponse detalheResponse = new DetalheResponse();

        if (idProduto <= 0) {
            throw new ApiErrorException(HttpStatus.BAD_REQUEST, "Id do produto inválido");
        }

        if (!produtoRepository.existsById(idProduto)) {
            throw new ApiErrorException(HttpStatus.BAD_REQUEST, "Produto não cadastrado.");
        }
        Produto produto = produtoRepository.getById(idProduto);
        detalheResponse.setImagens(produto.getImagens());
        detalheResponse.setNome(produto.getNome());
        detalheResponse.setPreco(produto.getValor());
        detalheResponse.setCaracteristicas(produto.getCaracteristicas());
        detalheResponse.setDescricao(produto.getDescricao());
        detalheResponse.setMediaNotas(calculaMediaNotas(produto.getOpinioes()));
        detalheResponse.setTotalNotas(produto.getOpinioes().size());
        detalheResponse.setOpinioes(produto.getOpinioes());
        detalheResponse.setPerguntas(produto.getPerguntas());

        return detalheResponse;
    }

    public Double calculaMediaNotas(List<Opiniao> opinioes) {
        Integer tamanho = opinioes.size();
        Integer somatorioNotas = 0;

        for (Opiniao op: opinioes) {
            somatorioNotas += op.getNota();
        }

        return somatorioNotas/tamanho.doubleValue();

    }

    public String converterImagemParaString(MultipartFile imagem) {
        String imagemEmString = null;
        try {//1
            imagemEmString = Base64.encodeBase64String(imagem.getBytes());
        } catch (IOException exception) {//1
            exception.printStackTrace();
        }
        return imagemEmString;
    }
}
