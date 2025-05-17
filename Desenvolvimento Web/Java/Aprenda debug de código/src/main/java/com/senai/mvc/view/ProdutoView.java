package com.senai.mvc.view;

import com.senai.mvc.controller.ClienteController;
import com.senai.mvc.controller.ProdutoController;
import com.senai.mvc.model.Cliente;
import com.senai.mvc.model.Produto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProdutoView {

    ProdutoController pt = new ProdutoController();

    @GetMapping("/produto")
    public List<Produto> getAllProdutos(){
        return pt.getAllProdutos();
    }

    @PostMapping("/produto")
    public Boolean postProduto(@RequestBody Produto p){
        return pt.save(p);
    }
}
