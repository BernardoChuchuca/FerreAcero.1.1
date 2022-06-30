package usp.edu.ec.FerreAcero.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import usp.edu.ec.FerreAcero.entidades.Persona;
import usp.edu.ec.FerreAcero.entidades.TarjetaCredito;
import usp.edu.ec.FerreAcero.entidades.peticiones.persona.ActualizarPersona;
import usp.edu.ec.FerreAcero.entidades.peticiones.persona.Crear_Persona;
import usp.edu.ec.FerreAcero.servicios.PersonaExeption;
import usp.edu.ec.FerreAcero.servicios.PersonaServicio;
import usp.edu.ec.FerreAcero.servicios.TarjetaServicio;

import java.util.List;
import java.util.Optional;


@RestController
public class TarjetaControlador {
    private TarjetaServicio tarjetaServicio;

    @Autowired
    public void setTarjetaServicio(TarjetaServicio tarjetaServicio) {
        this.tarjetaServicio = tarjetaServicio;
    }

    @GetMapping("/TarjetaCredito")
    public ResponseEntity<List<TarjetaCredito>> getAllTarjeta(){

        List<TarjetaCredito> listaTarjeta=tarjetaServicio.findAll();

        return new ResponseEntity<List<TarjetaCredito>>(listaTarjeta, HttpStatus.OK);
    }


}

