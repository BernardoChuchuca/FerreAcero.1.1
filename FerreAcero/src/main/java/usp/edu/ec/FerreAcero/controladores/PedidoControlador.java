package usp.edu.ec.FerreAcero.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import usp.edu.ec.FerreAcero.entidades.Carrito;
import usp.edu.ec.FerreAcero.entidades.Pedido;
import usp.edu.ec.FerreAcero.entidades.Persona;
import usp.edu.ec.FerreAcero.entidades.Producto;
import usp.edu.ec.FerreAcero.entidades.peticiones.pedido.ActualizarPedido;
import usp.edu.ec.FerreAcero.entidades.peticiones.pedido.CrearPedido;
import usp.edu.ec.FerreAcero.servicios.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PedidoControlador {

    private PedidoServicio pedidoServicio;

    private PersonaServicio personaServicio;

    private ProductoServicio productoServicio;

    private CarritoServicio carritoServicio;

    @Autowired
    public void setPedidoServicio(PedidoServicio pedidoServicio) {
        this.pedidoServicio = pedidoServicio;

    }

    @Autowired
    public void setPersonaServicio(PersonaServicio personaServicio) {
        this.personaServicio = personaServicio;
    }

    @Autowired
    public void setProductoServicio(ProductoServicio productoServicio) {
        this.productoServicio = productoServicio;
    }

    public void setCarritoServicio(CarritoServicio carritoServicio) {
        this.carritoServicio = carritoServicio;
    }

    @GetMapping("/pedidos")
    public ResponseEntity<List<Pedido>> getAllPedido(){

        List<Pedido> listaPedido=pedidoServicio.findAll();

        return new ResponseEntity<List<Pedido>>(listaPedido, HttpStatus.OK);

    }

    @GetMapping("/pedido/{numero}")

    public ResponseEntity<Pedido> getPedido(@PathVariable int numero) throws PedidoException{
        Optional<Pedido> pedido = Optional.ofNullable(pedidoServicio.ConsultaDatosPedido(numero));
        Pedido pedido1 = pedido.orElseThrow(PedidoException::new);

        return new ResponseEntity<Pedido>(pedido1, HttpStatus.OK);

    }


    @PostMapping("pedido/crear")
    public ResponseEntity<Pedido> crearPedido(@RequestBody CrearPedido crearPedido){
        Optional<Persona> persona = personaServicio.findByCodigo(crearPedido.getPersona_id());
        if(persona.isEmpty()){
            return ResponseEntity.badRequest().build();
        }
        Optional<Producto> producto = productoServicio.findByCodigo(crearPedido.getProducto_id());
        if(producto.isEmpty()){
            return ResponseEntity.badRequest().build();
        }
        Optional<Carrito> carrito = carritoServicio.findById(crearPedido.getCarrito_id());
        if(carrito.isEmpty()){
            return ResponseEntity.badRequest().build();
        }
        Pedido pedido = new Pedido();
        pedido.setNumero(crearPedido.getNumero());
        pedido.setPersona(persona.get());
        pedido.setProducto(producto.stream().toList());
        pedido.setCarrito(carrito.get());
        pedidoServicio.save(pedido);

        return ResponseEntity.ok(pedido);
    }

    @PutMapping("carrito/editar")
    public ResponseEntity<String>editarPedido(@RequestBody ActualizarPedido actualizarPedido){
        Optional<Pedido> pedidoOptional = pedidoServicio.findById(actualizarPedido.getId());

        if(pedidoOptional.isEmpty()){
            return ResponseEntity.badRequest().build();
        }

        Pedido pedidof=pedidoOptional.get();
        pedidof.setId(actualizarPedido.getId());
        pedidof.setNumero(actualizarPedido.getNumero());
        pedidoServicio.save(pedidof);

        return ResponseEntity.ok("Pedido Actualizado");
    }

    @DeleteMapping("carrito/delete/{id}")
    public ResponseEntity<String>deletePedido(@PathVariable int id){
        pedidoServicio.delete(id);
        return ResponseEntity.ok("Pedido Eliminado");
    }

}
