package com.tpTodoCode.regaleria.service;

import com.tpTodoCode.regaleria.entity.Producto;
import com.tpTodoCode.regaleria.repository.IProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService implements IProductoService{

    @Autowired
    private IProductoRepository repository;

    @Override
    public List<Producto> allProductos() throws Exception {
        List<Producto> productos = repository.findAll();
        if(productos.isEmpty()){
            throw new Exception("No se encontraron productos");
        }
        return productos;
    }

    @Override
    public String saveProducto(Producto p){
        repository.save(p);
        return "Producto almacenado correctamente";
    }

    @Override
    public String saveProductos(List<Producto> productos){
        repository.saveAll(productos);
        return "Productos almacenados correctamente";
    }


    @Override
    public String editProducto(Long idP, Producto p) throws Exception {
        if(!repository.existsById(idP)){
            throw new Exception("El producto que desea eliminar no se enceunra en la BDD");
        }
        this.saveProducto(p);
        return "Producto editado correctamente";
    }

    @Override
    public Producto deleteProducto(Long id) throws Exception {
        Producto pDelete = repository.findById(id).get();
        if(pDelete == null){
            throw new Exception("El producto que desea eliminar no se enceuntra cargado");
        }
        repository.deleteById(id);
        return pDelete;
    }

    @Override
    public Producto searchProductoId(Long id) throws Exception{
        return repository.findById(id)
                .orElseThrow(() -> new Exception("El producto no fue encontrado"));
    }



}
