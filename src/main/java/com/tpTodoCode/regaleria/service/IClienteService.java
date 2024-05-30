package com.tpTodoCode.regaleria.service;

import com.tpTodoCode.regaleria.entity.Cliente;
import com.tpTodoCode.regaleria.entity.Producto;

import java.util.List;

public interface IClienteService {

    public List<Cliente> allProductos() throws Exception;
    public String saveProducto(Cliente c);
    public String editProducto(Long idC, Cliente c) throws Exception;
    public Cliente deleteProducto(Long id) throws Exception;
    public Cliente searchProductoId(Long id) throws Exception;


}
