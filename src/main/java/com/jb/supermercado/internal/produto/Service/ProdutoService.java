package com.jb.supermercado.internal.produto.Service;

import com.jb.supermercado.config.exception.BusinessException;
import com.jb.supermercado.config.exception.RecursoNaoEncontradoException;
import com.jb.supermercado.internal.produto.dto.ProdutoRequestRecord;
import com.jb.supermercado.internal.produto.dto.ProdutoResponseRecord;
import com.jb.supermercado.internal.produto.entity.ProdutoEntity;
import com.jb.supermercado.internal.produto.mapper.ProdutoMapperRecord;
import com.jb.supermercado.internal.produto.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    private  final ProdutoRepository produtoRepository;

    public  ProdutoService (ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
     }

     public List<ProdutoResponseRecord> listarProdutos(){
        List<ProdutoEntity> produtos = this.produtoRepository.findAll();
        return ProdutoMapperRecord.responseParaEntity(produtos);
     }

     public void cadastrarProdutos (ProdutoRequestRecord produtoRequest){
        boolean nomeJaExiste = this.produtoRepository.existsByNome(produtoRequest.nome());
        if (nomeJaExiste) {
            throw new BusinessException("Já existe um produto cadastrado com este nome");
        }
        ProdutoEntity produtoEntity = ProdutoMapperRecord.requestParaEntity(produtoRequest);
        this.produtoRepository.save(produtoEntity);
     }

     public ProdutoResponseRecord buscarProdutoPorId(Long id){
        ProdutoEntity produtoEntity = this.produtoRepository.findById(id).orElseThrow(() ->
                new RecursoNaoEncontradoException("Produto nao Encontrado"));
        return ProdutoMapperRecord.responseParaEntity(produtoEntity);
     }

     public void atualizarProduto(Long id, ProdutoRequestRecord produtoRequest){
        ProdutoEntity produtoEntity = this.produtoRepository.findById(id).orElseThrow(()
                -> new RecursoNaoEncontradoException("Produto nao Encontrado"));
        produtoEntity.setNome(produtoRequest.nome());
        produtoEntity.setDescicao(produtoRequest.descricao());
        produtoEntity.setPreco(produtoRequest.preco());
        produtoEntity.setQuantidadeEstoque(produtoRequest.quantidadeEstoque());
        produtoEntity.setStatus(produtoRequest.status());
        this.produtoRepository.save(produtoEntity);
     }

     public void removerProduto(Long id){
        this.produtoRepository.deleteById(id);
     }



}
