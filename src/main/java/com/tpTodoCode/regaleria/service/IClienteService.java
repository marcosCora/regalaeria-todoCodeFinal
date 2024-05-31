package com.tpTodoCode.regaleria.service;

import com.tpTodoCode.regaleria.entity.Cliente;
import com.tpTodoCode.regaleria.entity.Producto;

import java.util.List;

public interface IClienteService {

    public List<Cliente> allCliente() throws Exception;
    public String saveCliente(Cliente c);
    public String editCliente(Long idC, Cliente c) throws Exception;
    public Cliente deleteCliente(Long id) throws Exception;
    public Cliente searchClienteId(Long id) throws Exception;
    public String saveClientes(List<Cliente> c);

}
