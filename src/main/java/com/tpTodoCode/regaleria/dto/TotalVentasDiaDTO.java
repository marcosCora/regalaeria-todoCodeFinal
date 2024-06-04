package com.tpTodoCode.regaleria.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TotalVentasDiaDTO {
    private LocalDate fecha;
    private double gananciaTotal;
    private int cantVentas;
}
