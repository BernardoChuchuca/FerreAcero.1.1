package usp.edu.ec.FerreAcero.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import usp.edu.ec.FerreAcero.entidades.Carrito;
import usp.edu.ec.FerreAcero.entidades.peticiones.carrito.CrearCarrito;
import usp.edu.ec.FerreAcero.servicios.CarritoServicio;

import java.util.List;

public class CarritoControlador {

    private CarritoServicio carritoServicio;

    @Autowired
    public void setCarritoServicio(CarritoServicio carritoServicio){

        this.carritoServicio = carritoServicio;

    }

    @GetMapping("/carritos")
    public ResponseEntity<List<Carrito>> getAllCarrito(){

        List<Carrito> listaCarrito=carritoServicio.findAll();

        return new ResponseEntity<List<Carrito>>(listaCarrito, HttpStatus.OK);
    }

  @PostMapping("carrito/create")
    public ResponseEntity<Carrito> crearPersona(@RequestBody CrearCarrito crearCarrito){
        Carrito carrito = new Carrito();
        carrito.setNumero(crearCarrito.getNumero());
        carrito.setFecha(crearCarrito.getFecha());
        carritoServicio.save(carrito);

        return ResponseEntity.ok(carrito);

  }

}
