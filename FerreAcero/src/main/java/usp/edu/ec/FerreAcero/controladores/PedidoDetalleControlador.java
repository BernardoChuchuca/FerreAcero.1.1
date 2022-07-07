package usp.edu.ec.FerreAcero.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import usp.edu.ec.FerreAcero.entidades.*;
import usp.edu.ec.FerreAcero.entidades.peticiones.pedidodetalle.ActualizarPedidoDetalle;
import usp.edu.ec.FerreAcero.entidades.peticiones.pedidodetalle.CrearPedidoDetalle;
import usp.edu.ec.FerreAcero.servicios.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class PedidoDetalleControlador {

    private PedidoDetalleServicio pedidoDetalleServicio;

    private ProductoServicio productoServicio;


    private PedidoServicio pedidoServicio;

    private List<PedidoDetalle> pedidoDetalleList=new ArrayList<>();

    @Autowired
    public void setPedidoDetalleServicio(PedidoDetalleServicio pedidoDetalleServicio) {
        this.pedidoDetalleServicio = pedidoDetalleServicio;

    }

    @Autowired
    public void setProductoServicio(ProductoServicio productoServicio) {
        this.productoServicio = productoServicio;
    }


    @Autowired
    public void setPedidoServicio(PedidoServicio pedidoServicio) {
        this.pedidoServicio = pedidoServicio;
    }


    @GetMapping("/pedidodetalles")
    public ResponseEntity<List<PedidoDetalle>> getAllPedidoDetalle(){

        List<PedidoDetalle> listaPedidodetalle=pedidoDetalleServicio.findAll();

        return new ResponseEntity<List<PedidoDetalle>>(listaPedidodetalle, HttpStatus.OK);

    }


    @PostMapping("/pedidodetalle/crear")
    public ResponseEntity<PedidoDetalle> crearPedidoDetalle(@RequestBody CrearPedidoDetalle crearPedidoDetalle){
       Optional<Producto> producto = productoServicio.findByCodigo(crearPedidoDetalle.getProducto_id());
       Producto producto1 = producto.orElseThrow(PedidoException::new);
       if(producto.isEmpty()){
           return ResponseEntity.badRequest().build();
       }


       Optional<Pedido> pedido = pedidoServicio.findById(crearPedidoDetalle.getPedido_id()) ;
       if(pedido.isEmpty()){

           return ResponseEntity.badRequest().build();
       }
       pedidoDetalleList = new Gestion().agregarProductos(pedidoDetalleList, producto1, crearPedidoDetalle.getCantidad());

        Pedido pedido1 = new Pedido();
        Persona persona1 = new Persona();
        persona1.setId(1);
        Carrito carrito1 = new Carrito();
        carrito1.setId(5);
        pedido1.setId(105);
        pedido1.setNumero(5);
        pedido1.setEstado("Eliminado");
        pedido1.setTotal(new Gestion().Total(pedidoDetalleList));
        pedido1.setPersona(persona1);
        pedido1.setCarrito(carrito1);

        PedidoDetalle pedidoDetalle = new PedidoDetalle();

        pedidoDetalle.setCantidad(crearPedidoDetalle.getCantidad());
        pedidoDetalle.setSubtotal(new Gestion().CalcularSubTotal(crearPedidoDetalle.getCantidad(), producto1.getPrecio()));
        pedidoDetalle.setPedido(pedido1);
        pedidoDetalle.setProducto(producto.get());
        pedidoDetalleServicio.save(pedidoDetalle);

       return ResponseEntity.ok(pedidoDetalle);

    }

    @PutMapping("/pedidodetalle/editar")
    public ResponseEntity<String>editarPedidoDetalle(@RequestBody ActualizarPedidoDetalle actualizarPedidoDetalle){
        Optional<PedidoDetalle> pedidoDetalleOptional = pedidoDetalleServicio.findById(actualizarPedidoDetalle.getId());

        if (pedidoDetalleOptional.isEmpty()){

            return ResponseEntity.badRequest().build();
        }

        PedidoDetalle pedidoDetalle1=pedidoDetalleOptional.get();

        pedidoDetalle1.setCantidad(actualizarPedidoDetalle.getCantidad());
        pedidoDetalle1.setId(actualizarPedidoDetalle.getId());
        pedidoDetalle1.setSubtotal(actualizarPedidoDetalle.getSubtotal());
        pedidoDetalleServicio.save(pedidoDetalle1);

        return ResponseEntity.ok("Pedido detalle Actualizado");

    }

    @DeleteMapping("/pedidodetalle/delete/{id}")

    public ResponseEntity<String>deletePedidoDetalle(@PathVariable int id){

        pedidoDetalleServicio.delete(id);

        return ResponseEntity.ok("Pedido Detalle Eliminado");

    }

}
