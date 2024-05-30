package com.tpTodoCode.regaleria.controllers;

import com.tpTodoCode.regaleria.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ControllerProducto {

    @Autowired
    IProductoService service;

    @GetMapping("producto/all")
    public ResponseEntity<?> allProductos(){
        ResponseEntity response = null;
        try{
            response = ResponseEntity.ok(service.allProductos());
        }catch (Exception e){
            response = ResponseEntity.badRequest().body("Error " + e.getMessage());
        }
        return response;
    }

    


}
