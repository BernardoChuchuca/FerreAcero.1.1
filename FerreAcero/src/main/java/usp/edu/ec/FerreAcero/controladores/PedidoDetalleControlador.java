package usp.edu.ec.FerreAcero.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import usp.edu.ec.FerreAcero.entidades.PedidoDetalle;
import usp.edu.ec.FerreAcero.entidades.peticiones.pedidodetalle.ActualizarPedidoDetalle;
import usp.edu.ec.FerreAcero.entidades.peticiones.pedidodetalle.CrearPedidoDetalle;
import usp.edu.ec.FerreAcero.servicios.PedidoDetalleServicio;
import usp.edu.ec.FerreAcero.servicios.ProductoServicio;

import java.util.List;
import java.util.Optional;

@RestController
public class PedidoDetalleControlador {

    private PedidoDetalleServicio pedidoDetalleServicio;

    private ProductoServicio productoServicio;

    @Autowired
    public void setPedidoDetalleServicio(PedidoDetalleServicio pedidoDetalleServicio) {
        this.pedidoDetalleServicio = pedidoDetalleServicio;

    }

    @Autowired
    public void setProductoServicio(ProductoServicio productoServicio) {
        this.productoServicio = productoServicio;
    }

    @GetMapping("/pedidodetalles")
    public ResponseEntity<List<PedidoDetalle>> getAllPedidoDetalle(){

        List<PedidoDetalle> listaPedidodetalle=pedidoDetalleServicio.findAll();

        return new ResponseEntity<List<PedidoDetalle>>(listaPedidodetalle, HttpStatus.OK);

    }


    @PostMapping("/pedidodetalle/crear")
    public ResponseEntity<PedidoDetalle> crearPedidoDetalle(@RequestBody CrearPedidoDetalle crearPedidoDetalle){
        PedidoDetalle pedidoDetalle = new PedidoDetalle();
        pedidoDetalle.setSubtotal(crearPedidoDetalle.getSubtotal());
        pedidoDetalle.getTotal(crearPedidoDetalle.getTotal());
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
