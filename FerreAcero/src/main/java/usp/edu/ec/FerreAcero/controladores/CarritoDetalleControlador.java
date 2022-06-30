package usp.edu.ec.FerreAcero.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import usp.edu.ec.FerreAcero.entidades.CarritoDetalle;
import usp.edu.ec.FerreAcero.entidades.peticiones.carritodetalle.CrearCarritoDetalle;
import usp.edu.ec.FerreAcero.servicios.CarritoDetalleServicio;

import java.util.List;

public class CarritoDetalleControlador {

    private CarritoDetalleServicio carritoDetalleServicio;

    @Autowired
    public void setCarritoDetalleServicio(CarritoDetalleServicio carritoDetalleServicio){

        this.carritoDetalleServicio = carritoDetalleServicio;
    }

    @GetMapping("/carritodetalles")
    public ResponseEntity<List<CarritoDetalle>> getAllCarritoDetalle(){

        List<CarritoDetalle> listaCarritoDetalle = carritoDetalleServicio.findAll();

        return new ResponseEntity<List<CarritoDetalle>>(listaCarritoDetalle, HttpStatus.OK);
    }

    @PostMapping("carritodetalle/create")
    public ResponseEntity<CarritoDetalle> crearCarritoDetalle(@RequestBody CrearCarritoDetalle crearCarritoDetalle){
        CarritoDetalle carritoDetalle = new CarritoDetalle();
        carritoDetalle.setValor_unitario(crearCarritoDetalle.getValor_unitario());
        carritoDetalle.setCantidad(crearCarritoDetalle.getCantidad());

        return ResponseEntity.ok(carritoDetalle);
    }

}
