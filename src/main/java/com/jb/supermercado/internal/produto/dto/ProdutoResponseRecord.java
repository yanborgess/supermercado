package com.jb.supermercado.internal.produto.dto;

public record ProdutoResponseRecord(Long id, String nome, String descicao, Long preco, int quantidadeEstoque,String status) {
}
