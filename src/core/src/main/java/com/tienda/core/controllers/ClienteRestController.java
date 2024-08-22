package com.tienda.core.controllers;

import com.tienda.core.domain.Cliente;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class ClienteRestController {

    private List<Cliente> clientes = new ArrayList<>(Arrays.asList(
           new Cliente( "arm", "1234", "Amstrong" ),
           new Cliente( "ald", "1234", "Aldrin" ),
           new Cliente( "cl", "1234", "Collins" )
        )
    );

    @GetMapping("/clientes")
    public List<Cliente> getClientes(){
        return clientes;
    }

    @GetMapping("/clientes/{userName}")
    public Cliente getClientes(@PathVariable String userName){

        return clientes.stream().
                filter(cliente -> cliente.getUsername().equalsIgnoreCase(userName)).
                findFirst().orElseThrow();
    }
}
