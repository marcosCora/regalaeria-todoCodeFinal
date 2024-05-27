package com.tpTodoCode.regaleria.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity(name = "ventas")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Venta {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long idVenta;
    private LocalDate fecha;
    private double total;
    @OneToMany(cascade = CascadeType.PERSIST)
    private List<Producto> productos;
    @ManyToOne(cascade = CascadeType.MERGE)
            @JoinColumn(name = "FK_IDCLIENTE",
                        referencedColumnName = "idCliente")
    Cliente cliente;
}
