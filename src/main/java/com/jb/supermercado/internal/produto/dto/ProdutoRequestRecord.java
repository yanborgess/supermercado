package com.jb.supermercado.internal.produto.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public record ProdutoRequestRecord(
        @NotBlank(message = "Nome e obrigatorio")
        String nome,
        @NotBlank(message = "Descrição e obrigatorio")
        String descricao,
        @Positive(message = "Valor tem que ser maior que zero")
        Long preco,
        @Positive(message = "Quantidade em estoque não negativo")
        int quantidadeEstoque,
        @NotBlank(message = "Status obrigatorio")
        String status
        ) {

}
