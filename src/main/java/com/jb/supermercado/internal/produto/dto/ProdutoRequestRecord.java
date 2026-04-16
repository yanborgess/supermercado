package com.jb.supermercado.internal.produto.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

public record ProdutoRequestRecord(
        @NotBlank(message = "Nome e obrigatorio")
        String nome,

        @NotBlank(message = "Descrição e obrigatorio")
        String descricao,

        @Positive(message = "Valor tem que ser maior que zero")
        double preco,

        @NotNull(message = "Quantidade em estoque obrigatorio")
        @PositiveOrZero(message = "Quantidade em estoque não pode ser negativo")
        Integer quantidadeEstoque,

        @NotBlank(message = "Status obrigatorio")
        String status
        ) {

}
