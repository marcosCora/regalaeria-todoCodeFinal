package com.tpTodoCode.regaleria.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Venta {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long idVenta;
    private LocalDate fecha;
    private double total;
    @OneToMany
    private List<Producto> productos;

    Cliente cliente;

}
