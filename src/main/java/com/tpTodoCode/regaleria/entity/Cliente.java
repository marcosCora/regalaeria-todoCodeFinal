package com.tpTodoCode.regaleria.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jdk.jfr.Enabled;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity(name = "clientes")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long idCliente;
    private String nombre;
    private String apellido;
    private String dni;
    @OneToMany(mappedBy = "cliente")
    @JsonIgnoreProperties(value = "cliente")
    private List<Venta> compras;
}
