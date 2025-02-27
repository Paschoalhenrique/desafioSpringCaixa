package com.desafio.produtosapi.controller;

import io.github.cursodsousa.produtosapi.model.Produto;
import io.github.cursodsousa.produtosapi.repository.ProdutoRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("produtos")
public class ProdutoController {

    private ProdutoRepository produtoRepository;

    public ProdutoController(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @PostMapping//("/produto")
    public Produto salvar(@RequestBody Produto produto){
        System.out.println("Produto Recebido: " + produto);

        var id = UUID.randomUUID().toString();
        produto.setId(id);

        produtoRepository.save(produto);
        return produto;
    }
    @Operation(description = "Buscar produto por id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Retorna produto"),
            @ApiResponse(responseCode = "400", description = "Não existe o produto com id informado ")
    })
    @GetMapping("{id}")
    public Produto obterPorId(@PathVariable("id") String id){
        return produtoRepository.findById(id).orElse(null);

    }
    @DeleteMapping("{id}")
    public void deletar(@PathVariable ("id") String id){
        produtoRepository.findById(id);
    }

    @PutMapping("{id}")
    public void atualizar (@PathVariable("id")String id,@RequestBody Produto produto){
        produto.setId(id);
        produtoRepository.save(produto);
    }

    @GetMapping
    public List<Produto> buscar(@RequestParam("nome")String nome){
        return produtoRepository.findByNome(nome);
    }
}
