package com.tpTodoCode.regaleria.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "productos")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long idProducto;
    private String nombre;
    private String marca;
    private double costo;
    private double cantDisponible;

    public void sumaStock(double cantidad){
        this.cantDisponible += cantidad;
    }

    public void restaStock(){
        this.cantDisponible --;
    }

}
