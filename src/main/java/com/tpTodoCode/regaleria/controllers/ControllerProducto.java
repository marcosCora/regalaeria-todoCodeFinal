package com.tpTodoCode.regaleria.controllers;

import com.tpTodoCode.regaleria.entity.Producto;
import com.tpTodoCode.regaleria.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ControllerProducto {

    @Autowired
    IProductoService service;

    @GetMapping("/productos")
    public ResponseEntity<?> allProductos(){
        ResponseEntity response = null;
        try{
            response = ResponseEntity.ok(service.allProductos());
        }catch (Exception e){
            response = ResponseEntity.badRequest().body("Error " + e.getMessage());
        }
        return response;
    }

    @GetMapping("/producto/{id}")
    public ResponseEntity<?> searchProductoId(@PathVariable Long id){
        ResponseEntity response = null;
        try{
            response = ResponseEntity.ok(service.searchProductoId(id));
        }catch (Exception e){
            response = ResponseEntity.badRequest().body("Error " + e.getMessage());
        }
        return response;
    }

    @PostMapping("/producto/save")
    public ResponseEntity<?> saveProducto(@RequestBody Producto p){
        return ResponseEntity.ok(service.saveProducto(p));
    }

    @DeleteMapping("/producto/delete/{id}")
    public ResponseEntity<?> deleteProducto(@PathVariable Long id){
        ResponseEntity response = null;
        try{
            response = ResponseEntity.ok(service.deleteProducto(id));
        }catch (Exception e){
            response = ResponseEntity.badRequest().body("Error " + e.getMessage());
        }
        return response;
    }

    @PutMapping("/producto/edit/{id}")
    public ResponseEntity<?> editProducto(@PathVariable Long id, @RequestBody Producto p){
        ResponseEntity response = null;
        try{
            response = ResponseEntity.ok(service.editProducto(id, p));
        }catch (Exception e){
            response = ResponseEntity.badRequest().body("Error " + e.getMessage());
        }
        return response;
    }

    

}
