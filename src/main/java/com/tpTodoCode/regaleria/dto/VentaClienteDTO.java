package com.tpTodoCode.regaleria.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class VentaClienteDTO {
    private Long idVenta;
    private double total;
    private int cantProductos;
    private String nombreCompletoCli;

}
