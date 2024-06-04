package com.tpTodoCode.regaleria.service;

import com.tpTodoCode.regaleria.dto.TotalVentasDiaDTO;
import com.tpTodoCode.regaleria.dto.VentaClienteDTO;
import com.tpTodoCode.regaleria.dto.VentaXCursoDTO;
import com.tpTodoCode.regaleria.entity.Cliente;
import com.tpTodoCode.regaleria.entity.Producto;
import com.tpTodoCode.regaleria.entity.Venta;
import com.tpTodoCode.regaleria.repository.IClienteRepository;
import com.tpTodoCode.regaleria.repository.IVentaRepository;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class VentaService implements IVentaService {

    @Autowired
    private IVentaRepository repository;
    @Autowired
    private IProductoService serviceProducto;

    @Override
    public List<Venta> allVentas() throws Exception {
        List<Venta> ventas = repository.findAll();
        if (ventas.isEmpty()) {
            throw new Exception("No se encontraron ventas");
        }
        return ventas;
    }

    @Override
    public String saveVentas(Venta v) throws Exception{
        if(v.getProductos().isEmpty() || v.getProductos() == null){
            throw new Exception("La lista de productos esta vacia");
        }
        v.setProductos(serviceProducto.setProductos(v.getProductos()));
        v.setFecha(LocalDate.now());
        v.setTotal(totalVenta(v.getProductos()));
        repository.save(v);
        return "Venta almacenada correctamente";
    }

    @Override
    public String editVentas(Long idV, Venta v) throws Exception {
        if (!repository.existsById(idV)) {
            throw new Exception("La venta que desea eliminar no se enceunra en la BDD");
        }
        this.saveVentas(v);
        return "Venta editada correctamente";
    }

    @Override
    public Venta deleteVentas(Long id) throws Exception {
        Venta vDelete = repository.findById(id).orElse(null);
        if (vDelete == null) {
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

    @Override
    public Double totalVenta(@NotNull List<Producto> productos) {
        double suma = 0;
        List<Producto> productosAux = new ArrayList<>(productos);
        for(Producto p : productosAux){
            suma += p.getCosto();
        }
        return suma;
    }

    @Override
    public VentaXCursoDTO productoDeVenta(Long id) throws Exception{
        Venta venta = this.searchVentasId(id);
        return new VentaXCursoDTO(venta.getIdVenta(), venta.getFecha(), venta.getProductos());
    }

    @Override
    public TotalVentasDiaDTO totalVentaXFecha(LocalDate fecha) throws Exception{
        List<Venta> ventas = this.allVentas();
        List<Venta> vFiltradas = ventas.stream()
                .filter(venta -> venta.getFecha().equals(fecha))
                .collect(Collectors.toList());
        if (vFiltradas.isEmpty()){
            throw new Exception("No hay ventas realizadas en esa fecha");
        }
        double total = gananciaTotal(vFiltradas);
        int totalProducotos = vFiltradas.size();
        return new TotalVentasDiaDTO(fecha, total, totalProducotos);
    }

    @Override
    public double gananciaTotal(List<Venta> ventas){
        double total = 0;
        for(Venta v : ventas){
            total += v.getTotal();
        }
        return total;
    }

    @Override
    public VentaClienteDTO mayorVenta() throws Exception{
        List<Venta> ventas = this.allVentas();
        Venta ventaMayor = ventas.get(0);

        for (Venta v : ventas){
            if(v.getTotal() > ventaMayor.getTotal()){
                ventaMayor = v;
            }
        }

        return new VentaClienteDTO(ventaMayor.getIdVenta(), ventaMayor.getTotal(),
                                   ventaMayor.getProductos().size(),
                                  (ventaMayor.getCliente().getNombre() + " " + ventaMayor.getCliente().getApellido()));
    }


}

