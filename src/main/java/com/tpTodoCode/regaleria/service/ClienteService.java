package com.tpTodoCode.regaleria.service;

import com.tpTodoCode.regaleria.entity.Cliente;
import com.tpTodoCode.regaleria.entity.Producto;
import com.tpTodoCode.regaleria.repository.IClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService implements IClienteService {

    @Autowired
    private IClienteRepository repository;

    @Override
    public List<Cliente> allProductos() throws Exception {
        List<Cliente> clientes = repository.findAll();
        if(clientes.isEmpty()){
            throw new Exception("No se encontraron clientes");
        }
        return clientes;
    }

    @Override
    public String saveProducto(Cliente c) {
        repository.save(c);
        return "Cliente almacenado correctamente";
    }

    @Override
    public String editProducto(Long idC, Cliente c) throws Exception {
        if(!repository.existsById(idC)){
            throw new Exception("El cliente que desea eliminar no se enceunra en la BDD");
        }
        this.saveProducto(c);
        return "Producto editado correctamente";
    }

    @Override
    public Cliente deleteProducto(Long id) throws Exception {
        Cliente cDelete = repository.findById(id).orElse(null);
        if(cDelete == null){
            throw new Exception("El cliente que desea eliminar no se enceuntra cargado");
        }
        repository.deleteById(id);
        return cDelete;
    }

    @Override
    public Cliente searchProductoId(Long id) throws Exception {
        return repository.findById(id)
                .orElseThrow(() -> new Exception("El cliente no fue encontrado"));
    }
}
