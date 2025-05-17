package com.senai.mvc.view;

import com.senai.mvc.controller.ClienteController;
import com.senai.mvc.model.Cliente;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ClienteView {

    ClienteController ct = new ClienteController();

    @GetMapping("/cliente")
    public List<Cliente> getAllClientes(){
        return ct.getAllClientes();
    }

    @PostMapping("/cliente")
    public Boolean postCliente(@RequestBody Cliente c){
        return ct.save(c);
    }
}
