package com.jb.supermercado.internal.produto.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "TB_PRODUTOS")
public class ProdutoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String descicao;
    private Long preco ;
    private int  quantidadeEstoque;
    private String status;


    public ProdutoEntity(Long id, String nome, String email, String senha, String status) {
        this.id = id;
        this.nome = nome;
        this.descicao = descicao;
        this.preco = preco;
        this.quantidadeEstoque = quantidadeEstoque;
        this.status = status;
    }

    public ProdutoEntity() {

    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescicao() {
        return descicao;
    }

    public void setDescicao(String descicao) {
        this.descicao = descicao;
    }

    public Long getPreco() {
        return preco;
    }

    public void setPreco(Long preco) {
        this.preco = preco;
    }

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(int quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
