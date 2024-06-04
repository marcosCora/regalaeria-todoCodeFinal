package com.tpTodoCode.regaleria.controllers;

import com.tpTodoCode.regaleria.entity.Producto;
import com.tpTodoCode.regaleria.entity.Venta;
import com.tpTodoCode.regaleria.service.IVentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
public class ControllerVenta {

    @Autowired
    private IVentaService service;

    @GetMapping("/ventas")
    public ResponseEntity<?> allVentas(){
        ResponseEntity response = null;
        try{
            response = ResponseEntity.ok(service.allVentas());
        }catch (Exception e){
            response = ResponseEntity.badRequest().body("Error " + e.getMessage());
        }
        return response;
    }

    @GetMapping("/venta/{id}")
    public ResponseEntity<?> searchVentaId(@PathVariable Long id){
        ResponseEntity response = null;
        try{
            response = ResponseEntity.ok(service.searchVentasId(id));
        }catch (Exception e){
            response = ResponseEntity.badRequest().body("Error " + e.getMessage());
        }
        return response;
    }

    @GetMapping("/venta/productos/{id}")
    public ResponseEntity<?> productoDeVenta(@PathVariable Long id){
        ResponseEntity response = null;
        try{
            response = ResponseEntity.ok(service.productoDeVenta(id));
        }catch (Exception e){
            response = ResponseEntity.badRequest().body("Error " + e.getMessage());
        }
        return response;
    }

    @GetMapping("/venta/total/{fecha}")
    public ResponseEntity<?> totalVentasXFecha(@PathVariable LocalDate fecha){
        ResponseEntity response = null;
        try{
            response = ResponseEntity.ok(service.totalVentaXFecha(fecha));
        }catch (Exception e){
            response = ResponseEntity.badRequest().body("Error " + e.getMessage());
        }
        return response;
    }

    @GetMapping("/venta/mayor_venta")
    public ResponseEntity<?> mayorVenta(){
        ResponseEntity response = null;
        try{
            response = ResponseEntity.ok(service.mayorVenta());
        }catch (Exception e){
            response = ResponseEntity.badRequest().body("Error " + e.getMessage());
        }
        return response;
    }

    @PostMapping("/venta/save")
    public ResponseEntity<?> saveVenta(@RequestBody Venta v){
        ResponseEntity response = null;
        try{
            response = ResponseEntity.ok(service.saveVentas(v));
        }catch (Exception e){
            response = ResponseEntity.badRequest().body("Error " + e.getMessage());
        }
        return response;
    }

    @DeleteMapping("/venta/delete/{id}")
    public ResponseEntity<?> deleteVenta(@PathVariable Long id){
        ResponseEntity response = null;
        try{
            response = ResponseEntity.ok(service.deleteVentas(id));
        }catch (Exception e){
            response = ResponseEntity.badRequest().body("Error " + e.getMessage());
        }
        return response;
    }

    @PutMapping("/venta/edit/{id}")
    public ResponseEntity<?> editVenta(@PathVariable Long id, @RequestBody Venta v){
        ResponseEntity response = null;
        try{
            response = ResponseEntity.ok(service.editVentas(id, v));
        }catch (Exception e){
            response = ResponseEntity.badRequest().body("Error " + e.getMessage());
        }
        return response;
    }




}
