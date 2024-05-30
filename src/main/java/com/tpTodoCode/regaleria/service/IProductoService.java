package com.tpTodoCode.regaleria.service;

import com.tpTodoCode.regaleria.entity.Producto;

import java.util.List;

public interface IProductoService {

    public List<Producto> allProductos() throws Exception;
    public String saveProducto(Producto p);
    public String editProducto(Long idP, Producto p) throws Exception;
    public Producto deleteProducto(Long id) throws Exception;
    public Producto searchProductoId(Long id) throws Exception;

}
