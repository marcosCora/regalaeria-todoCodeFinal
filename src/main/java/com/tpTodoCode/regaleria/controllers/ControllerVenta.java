package com.tpTodoCode.regaleria.controllers;

import com.tpTodoCode.regaleria.entity.Producto;
import com.tpTodoCode.regaleria.entity.Venta;
import com.tpTodoCode.regaleria.service.IVentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ControllerVenta {

    @Autowired
    private IVentaService service;

    @GetMapping("/ventas")
    public ResponseEntity<?> allProductos(){
        ResponseEntity response = null;
        try{
            response = ResponseEntity.ok(service.allVentas());
        }catch (Exception e){
            response = ResponseEntity.badRequest().body("Error " + e.getMessage());
        }
        return response;
    }

    @GetMapping("/venta/{id}")
    public ResponseEntity<?> searchProductoId(@PathVariable Long id){
        ResponseEntity response = null;
        try{
            response = ResponseEntity.ok(service.searchVentasId(id));
        }catch (Exception e){
            response = ResponseEntity.badRequest().body("Error " + e.getMessage());
        }
        return response;
    }

    @PostMapping("/venta/save")
    public ResponseEntity<?> saveProducto(@RequestBody Venta v){
        return ResponseEntity.ok(service.saveVentas(v));
    }

    @DeleteMapping("/venta/delete/{id}")
    public ResponseEntity<?> deleteProducto(@PathVariable Long id){
        ResponseEntity response = null;
        try{
            response = ResponseEntity.ok(service.deleteVentas(id));
        }catch (Exception e){
            response = ResponseEntity.badRequest().body("Error " + e.getMessage());
        }
        return response;
    }

    @PutMapping("/venta/edit/{id}")
    public ResponseEntity<?> editProducto(@PathVariable Long id, @RequestBody Venta v){
        ResponseEntity response = null;
        try{
            response = ResponseEntity.ok(service.editVentas(id, v));
        }catch (Exception e){
            response = ResponseEntity.badRequest().body("Error " + e.getMessage());
        }
        return response;
    }




}
