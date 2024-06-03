package com.tpTodoCode.regaleria.service;

import com.tpTodoCode.regaleria.entity.Producto;
import com.tpTodoCode.regaleria.repository.IProductoRepository;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

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
    public void editProducto(Long idP, Producto p) throws Exception {
        if(!repository.existsById(idP)){
            throw new Exception("El producto al que desea acceder no se enceunra en la BDD");
        }
        this.saveProducto(p);
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

    //esta funcion recibe una lista de producto que se manda desde la vista
    //osea solo recibe los id por ende hay que asignar
    @Override
    public List<Producto> setProductos(@NotNull List<Producto> productosId) throws Exception {
        List<Long> ids = new ArrayList<>();
        for(Producto p : productosId){
            ids.add(p.getIdProducto());
        }
        List<Producto> productos = repository.findAllById(ids);
        if(productos.size() != ids.size()){
            throw new Exception("Productos con ID invalido");
        }
        this.editStockProduct(productos);
        return productos;
    }

    @Override
    public void editStockProduct(@NotNull List<Producto> productos) throws Exception{
        List<Producto> productosAux = new ArrayList<>(productos);
        for(Producto p : productosAux){
            p.restaStock();
            this.editProducto(p.getIdProducto(), p);
        }
    }



}
