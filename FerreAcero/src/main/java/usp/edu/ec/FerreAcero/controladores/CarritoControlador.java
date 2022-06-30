package usp.edu.ec.FerreAcero.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import usp.edu.ec.FerreAcero.entidades.Carrito;
import usp.edu.ec.FerreAcero.entidades.peticiones.carrito.CrearCarrito;
import usp.edu.ec.FerreAcero.servicios.CarritoServicio;

import java.util.List;
@RestController
public class CarritoControlador {

    private CarritoServicio carritoservicio;
    @Autowired
    public void setCarritoservicio(CarritoServicio carritoservicio) {
        this.carritoservicio = carritoservicio;
    }

    @GetMapping("/carritos")
    public ResponseEntity<List<Carrito>> getAllCarrito(){

        List<Carrito> listaCarrito=carritoservicio.findAll();

        return new ResponseEntity<List<Carrito>>(listaCarrito, HttpStatus.OK);
    }

  @PostMapping("carrito/create")
    public ResponseEntity<Carrito> crearPersona(@RequestBody CrearCarrito crearCarrito){
        Carrito carrito = new Carrito();
        carrito.setNumero(crearCarrito.getNumero());
        carrito.setFecha(crearCarrito.getFecha());
        carritoservicio.save(carrito);

        return ResponseEntity.ok(carrito);

  }

}
