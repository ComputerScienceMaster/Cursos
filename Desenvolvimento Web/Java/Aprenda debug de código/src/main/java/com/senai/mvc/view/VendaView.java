package com.senai.mvc.view;

import com.senai.mvc.controller.ClienteController;
import com.senai.mvc.controller.VendaController;
import com.senai.mvc.model.Cliente;
import com.senai.mvc.model.Venda;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class VendaView {

    VendaController ct = new VendaController();

    @GetMapping("/venda")
    public List<Venda> getAllVendas(){
        return ct.getAllVendas();
    }

    @PostMapping("/venda")
    public Boolean postVendas(@RequestBody Venda v){
        return ct.save(v);
    }
}
