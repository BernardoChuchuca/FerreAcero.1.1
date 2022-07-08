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

    private PersonaServicio personaServicio;


    private List<PedidoDetalle> pedidoDetalleList=new ArrayList<>();

    Gestion ges;

    @Autowired
    public void setPedidoDetalleServicio(PedidoDetalleServicio pedidoDetalleServicio) {
        this.pedidoDetalleServicio = pedidoDetalleServicio;

    }
    @Autowired
    public void setPersonaServicio(PersonaServicio personaServicio) {
        this.personaServicio = personaServicio;
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

int cont=1;
    @PostMapping("/pedidoadd/po/crear")
    public ResponseEntity<PedidoDetalle> crearPedidoDetalle(){
       Optional<Producto> producto = productoServicio.findByCodigo(2);
       Producto producto1 = producto.orElseThrow(PedidoException::new);
       if(producto.isEmpty()){
           return ResponseEntity.badRequest().build();
       }
        Optional<Persona> persona = personaServicio.findByCodigo(ges.getId_persona());
        if(persona.isEmpty()){

            return ResponseEntity.badRequest().build();
        }

       pedidoDetalleList = new Gestion().agregarProductos(pedidoDetalleList, producto1, 4);
        Pedido pedido1 = new Pedido();
       if(cont==1){
           Carrito carrito1 = new Carrito();
           carrito1.setId(1);
           pedido1.setId(125);
           pedido1.setNumero(5);
           pedido1.setEstado("Habilitado");
           pedido1.setTotal(new Gestion().Total(pedidoDetalleList));
           pedido1.setPersona(persona.get());
           pedido1.setCarrito(carrito1);
           pedidoServicio.save(pedido1);
           cont=2;
       }
       //----------------------------------------------------------------------------------------------------------------//
        PedidoDetalle pedidoDetalle = new PedidoDetalle();
        pedidoDetalle.setSubtotal(new Gestion().CalcularSubTotal(4, producto1.getPrecio()));
        //---------------------------------------------------------------------------------------------------------------//

        pedido1.setId(pedidoServicio.findByPedidoMax());

        //----------agregar------------------//

        PedidoDetalle pd=new PedidoDetalle();
        pd.setPedido(pedido1);
        pd.setCantidad(4);
        pd.setSubtotal(new Gestion().CalcularSubTotal(4, producto1.getPrecio()));
        pd.setProducto(producto1);

        //-------------------------------------//




        pedidoDetalleServicio.save(pd);

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

    public void Resx(Gestion ges){
        this.ges=ges;



    }



}
