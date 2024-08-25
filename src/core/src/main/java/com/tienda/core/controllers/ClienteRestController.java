package com.tienda.core.controllers;

import com.tienda.core.domain.Cliente;
import com.tienda.core.exceptions.BadRequestException;
import com.tienda.core.exceptions.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteRestController {

    private List<Cliente> clientes = new ArrayList<>(Arrays.asList(
           new Cliente( "arm", "1234", "Amstrong" ),
           new Cliente( "ald", "1234", "Aldrin" ),
           new Cliente( "cl", "1234", "Collins" )
        )
    );

    @GetMapping
    public ResponseEntity<List<?>> getClientes(){
        return ResponseEntity.ok(clientes);
    }

    @GetMapping("/{userName}")
    public ResponseEntity<?> getClientes(@PathVariable String userName){

        if(userName.length() != 3){
            throw new BadRequestException("El parámetro nombre de usuario debe contener 3 caracteres");
        }

        return clientes.stream()
                .filter(c -> c.getUsername().equalsIgnoreCase(userName))
                .findFirst()
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new ResourceNotFoundException("Cliente " + userName + " no encontrado."));
    }

    @PostMapping
    public ResponseEntity<?> altaCliente(@RequestBody Cliente cliente){
        clientes.add(cliente);

        //Obteniendo URL del servicio
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{userName}")
                .buildAndExpand(cliente.getUsername())
                .toUri();

        return ResponseEntity.created(location).body(cliente);
    }

    @PutMapping
    public ResponseEntity<?> modificacionCliente(@RequestBody Cliente cliente){
        Cliente clienteEncontrado = clientes.stream().
                filter(c -> c.getUsername().equalsIgnoreCase(cliente.getUsername())).
                findFirst().orElseThrow();
        clienteEncontrado.setPassword(cliente.getPassword());
        clienteEncontrado.setNombre(cliente.getNombre());

        return ResponseEntity.ok(clienteEncontrado);
    }

    @DeleteMapping("/{userName}")
    public ResponseEntity deleteCliente(@PathVariable String userName){
        Cliente clienteEncontrado = clientes.stream().
                filter(c -> c.getUsername().equalsIgnoreCase(userName)).
                findFirst().orElseThrow();

        clientes.remove(clienteEncontrado);

        return ResponseEntity.noContent().build();
    }
}
