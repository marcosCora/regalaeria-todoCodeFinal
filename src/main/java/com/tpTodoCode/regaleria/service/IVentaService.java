package com.tpTodoCode.regaleria.service;

import com.tpTodoCode.regaleria.dto.TotalVentasDiaDTO;
import com.tpTodoCode.regaleria.dto.VentaClienteDTO;
import com.tpTodoCode.regaleria.dto.VentaXCursoDTO;
import com.tpTodoCode.regaleria.entity.Producto;
import com.tpTodoCode.regaleria.entity.Venta;

import java.time.LocalDate;
import java.util.List;

public interface IVentaService {

    public List<Venta> allVentas() throws Exception;
    public String saveVentas(Venta v)throws Exception;
    public String editVentas(Long idV, Venta v) throws Exception;
    public Venta deleteVentas(Long id) throws Exception;
    public Venta searchVentasId(Long id) throws Exception;
    public Double totalVenta(List<Producto> productos);
    public VentaXCursoDTO productoDeVenta(Long id) throws Exception;
    public TotalVentasDiaDTO totalVentaXFecha(LocalDate fecha) throws Exception;
    public double gananciaTotal(List<Venta> ventas);
    public VentaClienteDTO mayorVenta() throws Exception;
}
