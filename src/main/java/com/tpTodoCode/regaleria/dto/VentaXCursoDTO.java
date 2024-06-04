package com.tpTodoCode.regaleria.dto;

import com.tpTodoCode.regaleria.entity.Producto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class VentaXCursoDTO {
    private long idVenta;
    private LocalDate fecha;
    private List<Producto> productos;
}
