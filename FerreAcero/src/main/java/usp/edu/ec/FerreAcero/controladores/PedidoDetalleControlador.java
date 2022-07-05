package usp.edu.ec.FerreAcero.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import usp.edu.ec.FerreAcero.entidades.CarritoDetalle;
import usp.edu.ec.FerreAcero.entidades.Pedido;
import usp.edu.ec.FerreAcero.entidades.PedidoDetalle;
import usp.edu.ec.FerreAcero.entidades.Producto;
import usp.edu.ec.FerreAcero.entidades.peticiones.pedidodetalle.ActualizarPedidoDetalle;
import usp.edu.ec.FerreAcero.entidades.peticiones.pedidodetalle.CrearPedidoDetalle;
import usp.edu.ec.FerreAcero.servicios.CarritoDetalleServicio;
import usp.edu.ec.FerreAcero.servicios.PedidoDetalleServicio;
import usp.edu.ec.FerreAcero.servicios.PedidoServicio;
import usp.edu.ec.FerreAcero.servicios.ProductoServicio;

import java.util.List;
import java.util.Optional;

@RestController
public class PedidoDetalleControlador {

    private PedidoDetalleServicio pedidoDetalleServicio;

    private ProductoServicio productoServicio;

    private CarritoDetalleServicio carritoDetalleServicio;

    private PedidoServicio pedidoServicio;

    @Autowired
    public void setPedidoDetalleServicio(PedidoDetalleServicio pedidoDetalleServicio) {
        this.pedidoDetalleServicio = pedidoDetalleServicio;

    }

    @Autowired
    public void setProductoServicio(ProductoServicio productoServicio) {
        this.productoServicio = productoServicio;
    }

    @Autowired
    public void setCarritoDetalleServicio(CarritoDetalleServicio carritoDetalleServicio) {
        this.carritoDetalleServicio = carritoDetalleServicio;
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
       if(producto.isEmpty()){
           return ResponseEntity.badRequest().build();
       }

       Optional<CarritoDetalle> carritoDetalle = carritoDetalleServicio.findById(crearPedidoDetalle.getCarritodetalle_id());
       if(carritoDetalle.isEmpty()){
           return ResponseEntity.badRequest().build();
       }

       Optional<Pedido> pedido = pedidoServicio.findById(crearPedidoDetalle.getPedido_id()) ;
       if(pedido.isEmpty()){

           return ResponseEntity.badRequest().build();
       }

       PedidoDetalle pedidoDetalle = new PedidoDetalle();
       pedidoDetalle.setSubtotal(crearPedidoDetalle.getSubtotal());
       pedidoDetalle.setTotal(crearPedidoDetalle.getTotal());
       pedidoDetalle.setPedido(pedido.get());
       pedidoDetalle.setProducto(producto.get());
       pedidoDetalle.setCarritoDetalle(carritoDetalle.get());
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

        pedidoDetalle1.setId(actualizarPedidoDetalle.getId());
        pedidoDetalle1.setSubtotal(actualizarPedidoDetalle.getSubtotal());
        pedidoDetalle1.setTotal(actualizarPedidoDetalle.getTotal());
        pedidoDetalleServicio.save(pedidoDetalle1);

        return ResponseEntity.ok("Pedido detalle Actualizado");

    }

    @DeleteMapping("/pedidodetalle/delete/{id}")

    public ResponseEntity<String>deletePedidoDetalle(@PathVariable int id){

        pedidoDetalleServicio.delete(id);

        return ResponseEntity.ok("Pedido Detalle Eliminado");

    }

}
