package com.jb.supermercado.internal.produto.mapper;

import com.jb.supermercado.internal.produto.dto.ProdutoRequestRecord;
import com.jb.supermercado.internal.produto.dto.ProdutoResponseRecord;
import com.jb.supermercado.internal.produto.entity.ProdutoEntity;

import java.util.ArrayList;
import java.util.List;

public class ProdutoMapperRecord {

    public static ProdutoEntity requestParaEntity(ProdutoRequestRecord produtoRequest) {
        ProdutoEntity produtoEntity = new ProdutoEntity();
        produtoEntity.setNome(produtoRequest.nome());
        produtoEntity.setDescicao(produtoRequest.descricao());
        produtoEntity.setPreco(produtoRequest.preco());
        produtoEntity.setQuantidadeEstoque(produtoRequest.quantidadeEstoque());
        produtoEntity.setStatus(produtoRequest.status());
        return produtoEntity;
    }

    public static ProdutoResponseRecord responseParaEntity(ProdutoEntity produtoEntity) {
        return new ProdutoResponseRecord(
                produtoEntity.getId(),
                produtoEntity.getNome(),
                produtoEntity.getDescicao(),
                produtoEntity.getPreco(),
                produtoEntity.getQuantidadeEstoque(),
                produtoEntity.getStatus());
    }

    public static List<ProdutoResponseRecord> responseParaEntity(List<ProdutoEntity> produtoEntityList) {
        List<ProdutoResponseRecord> produtoResponseRecordList = new ArrayList<>();
        for (ProdutoEntity produtoEntity : produtoEntityList){
            produtoResponseRecordList.add(responseParaEntity(produtoEntity));
        }
        return produtoResponseRecordList;
    }
}
