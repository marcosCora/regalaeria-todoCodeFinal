package com.tpTodoCode.regaleria.service;

import com.tpTodoCode.regaleria.entity.Venta;

import java.util.List;

public interface IVentaService {

    public List<Venta> allVentas() throws Exception;
    public String saveVentas(Venta v);
    public String editVentas(Long idV, Venta v) throws Exception;
    public Venta deleteVentas(Long id) throws Exception;
    public Venta searchVentasId(Long id) throws Exception;
}
