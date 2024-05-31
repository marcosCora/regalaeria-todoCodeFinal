package com.tpTodoCode.regaleria.service;

import com.tpTodoCode.regaleria.entity.Cliente;
import com.tpTodoCode.regaleria.entity.Venta;
import com.tpTodoCode.regaleria.repository.IClienteRepository;
import com.tpTodoCode.regaleria.repository.IVentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VentaService implements IVentaService{

    @Autowired
    private IVentaRepository repository;

    @Override
    public List<Venta> allVentas() throws Exception {
        List<Venta> ventas = repository.findAll();
        if(ventas.isEmpty()){
            throw new Exception("No se encontraron clientes");
        }
        return ventas;
    }

    @Override
    public String saveVentas(Venta v) {
        repository.save(v);
        return "Venta almacenada correctamente";
    }

    @Override
    public String editVentas(Long idV, Venta v) throws Exception {
        if(!repository.existsById(idV)){
            throw new Exception("La venta que desea eliminar no se enceunra en la BDD");
        }
        this.saveVentas(v);
        return "Venta editada correctamente";
    }

    @Override
    public Venta deleteVentas(Long id) throws Exception {
        Venta vDelete = repository.findById(id).orElse(null);
        if(vDelete == null){
            throw new Exception("La venta que desea eliminar no se enceuntra cargado");
        }
        repository.deleteById(id);
        return vDelete;
    }

    @Override
    public Venta searchVentasId(Long id) throws Exception {
        return repository.findById(id)
                .orElseThrow(() -> new Exception("La venta no fue encontrado"));
    }
}
