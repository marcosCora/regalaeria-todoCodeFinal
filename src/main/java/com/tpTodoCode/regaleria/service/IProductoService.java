package com.tpTodoCode.regaleria.service;

import com.tpTodoCode.regaleria.entity.Producto;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.List;

public interface IProductoService {

    public List<Producto> allProductos() throws Exception;
    public String saveProducto(Producto p);
    public String saveProductos(List<Producto> productos);
    public void editProducto(Long idP, Producto p) throws Exception;
    public Producto deleteProducto(Long id) throws Exception;
    public Producto searchProductoId(Long id) throws Exception;
    public List<Producto> setProductos(List<Producto> productosId) throws Exception;
    public void editStockProduct(@NotNull List<Producto> productos) throws Exception;
    public List<Producto> productosFaltantes() throws Exception;
}
