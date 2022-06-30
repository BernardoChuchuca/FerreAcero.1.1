package usp.edu.ec.FerreAcero.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import usp.edu.ec.FerreAcero.entidades.FormaPago;
import usp.edu.ec.FerreAcero.entidades.Sucursal;
import usp.edu.ec.FerreAcero.servicios.FormaPagoExeption;
import usp.edu.ec.FerreAcero.servicios.SucursalException;
import usp.edu.ec.FerreAcero.servicios.SucursalServicio;

import java.util.Optional;

@RestController
public class SucursalControlador {

    private SucursalServicio sucursalServicio;

    @Autowired
    public void setSucursalServicio(SucursalServicio sucursalServicio) {
        this.sucursalServicio = sucursalServicio;
    }

    @GetMapping("sucursal/nombre/{sucursal}")

    public ResponseEntity<Sucursal> getSucursal(@PathVariable String sucursal) throws SucursalException {
        Optional<Sucursal> sucursal1 = Optional.ofNullable(sucursalServicio.ConsultaDatosP(sucursal));
        Sucursal sucursal2 = sucursal1.orElseThrow(FormaPagoExeption::new);

        return new ResponseEntity<Sucursal>(sucursal2, HttpStatus.OK);
    }

}