package com.tpTodoCode.regaleria.controllers;

import com.tpTodoCode.regaleria.entity.Cliente;
import com.tpTodoCode.regaleria.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ControllerCliente {

    @Autowired
    private ClienteService service;

    @GetMapping("/clientes")
    public ResponseEntity<?> allVentas(){
        ResponseEntity response = null;
        try{
            response = ResponseEntity.ok(service.allCliente());
        }catch (Exception e){
            response = ResponseEntity.badRequest().body("Error " + e.getMessage());
        }
        return response;
    }

    @GetMapping("/cliente/{id}")
    public ResponseEntity<?> searchProducto(@PathVariable Long id){
        ResponseEntity response = null;
        try{
            response = ResponseEntity.ok(service.searchClienteId(id));
        }catch (Exception e){
            response = ResponseEntity.badRequest().body("Error " + e.getMessage());
        }
        return response;
    }

    @PostMapping("/cliente/save")
    public ResponseEntity<?> saveCliente(@RequestBody Cliente c){
        return ResponseEntity.ok(service.saveCliente(c));
    }

    @PostMapping("/clientes/save")
    public ResponseEntity<?> saveClientes(@RequestBody List<Cliente> c){
        return ResponseEntity.ok(service.saveClientes(c));
    }

    @DeleteMapping("/cliente/delete/{id}")
    public ResponseEntity<?> deleteCliente(@PathVariable Long id){
        ResponseEntity response = null;
        try{
            response = ResponseEntity.ok(service.deleteCliente(id));
        }catch (Exception e){
            response = ResponseEntity.badRequest().body("Error " + e.getMessage());
        }
        return response;
    }

    @PutMapping("/cliente/edit/{id}")
    public ResponseEntity<?> editCliente(@PathVariable Long id, @RequestBody Cliente c){
        ResponseEntity response = null;
        try{
            response = ResponseEntity.ok(service.editCliente(id, c));
        }catch (Exception e){
            response = ResponseEntity.badRequest().body("Error " + e.getMessage());
        }
        return response;
    }

}
