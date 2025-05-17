package com.senai.crudSemBanco.view;

import com.senai.crudSemBanco.controller.ProdutoController;
import com.senai.crudSemBanco.model.Produto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProdutoView {

    ProdutoController pc = new ProdutoController();

    @GetMapping("/produto")
    public List<Produto> getAllProdutos(){
        return pc.pegarTodosOsProdutos();
    }

    @PostMapping("/produto")
    public String postNovoProduto(@RequestBody Produto p){
        pc.inserirNoBanco(p);
        return "Sucesso";
    }
}
