package com.jb.supermercado.internal.produto.controller;


import com.jb.supermercado.internal.produto.Service.ProdutoService;
import com.jb.supermercado.internal.produto.dto.ProdutoRequestRecord;
import com.jb.supermercado.internal.produto.dto.ProdutoResponseRecord;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/produtos")
public class ProdutoController {

    private final ProdutoService produtosService;

    public ProdutoController(ProdutoService produtosService) {
        this.produtosService = produtosService;
    }

    @GetMapping
    public ResponseEntity<List<ProdutoResponseRecord>> listar(){
        return ResponseEntity.ok(this.produtosService.listarProdutos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoResponseRecord> buscar(@PathVariable Long id) {
        return ResponseEntity.ok(this.produtosService.buscarProdutoPorId(id));
    }

    @PostMapping
    public ResponseEntity<ProdutoResponseRecord> cadastrar(@Valid @RequestBody ProdutoRequestRecord produtoRequest) {
        this.produtosService.cadastrarProdutos(produtoRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> atualizar(@PathVariable Long id, @RequestBody ProdutoRequestRecord produtoRequest) {
        this.produtosService.atualizarProduto(id, produtoRequest);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id) {
        this.produtosService.removerProduto(id);
        return ResponseEntity.noContent().build();
    }
}
