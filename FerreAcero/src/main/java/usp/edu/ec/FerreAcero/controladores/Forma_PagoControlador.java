package usp.edu.ec.FerreAcero.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import usp.edu.ec.FerreAcero.entidades.Forma_Pago;
import usp.edu.ec.FerreAcero.entidades.peticiones.persona.ActualizarForma_Pago;
import usp.edu.ec.FerreAcero.entidades.peticiones.persona.CrearForma_Pago;
import usp.edu.ec.FerreAcero.servicios.Forma_PagoNoEncontradaException;
import usp.edu.ec.FerreAcero.servicios.Forma_PagoServicio;

import java.util.List;
import java.util.Optional;

@RestController
public class Forma_PagoControlador {
    private Forma_PagoServicio forma_pagoServicio;

    @Autowired //Injeccion de dependencia
    public void setForma_PagoServicio(Forma_PagoServicio forma_pagoServicio) {
        this.forma_pagoServicio = forma_pagoServicio;
    }

    @GetMapping("/forma_pagos")
    public ResponseEntity<List<Forma_Pago>> getAllForma_Pagos(){
        List<Forma_Pago> listaForma_Pagos = forma_pagoServicio.findAll();
        return new ResponseEntity<List<Forma_Pago>>(listaForma_Pagos, HttpStatus.OK);
    }

    @GetMapping("{codigo}/tipo_pago")
    public ResponseEntity<String> getTipo_PagosByCodigo(@PathVariable Long codigo){
        String tipo_pago = forma_pagoServicio.retrieveForma_PagoTipo_PagoByCodigo(codigo);
        return new ResponseEntity<String>(tipo_pago, HttpStatus.OK);
    }

    @GetMapping("/forma_pagos/tipo_pagos")
    public ResponseEntity<List<String>> getAllTipo_Pagos(){
        List<String> listaTipo_Pagos = forma_pagoServicio.retriveAllTipo_Pagos();
        return new ResponseEntity<List<String>>(listaTipo_Pagos, HttpStatus.OK);
    }

    @GetMapping("forma_pago/{tipo_pago}")
    public ResponseEntity<Forma_Pago> getForma_PagoByTipo_Pago(@PathVariable String tipo_pago){
        Optional<Forma_Pago> forma_pagoOptional = Optional.ofNullable(forma_pagoServicio.retriveForma_PagoByTipo_Pago(tipo_pago));
        Forma_Pago forma_pago = forma_pagoOptional.orElseThrow(Forma_PagoNoEncontradaException::new);
        return new ResponseEntity<Forma_Pago>(forma_pago, HttpStatus.OK);
    }

    @PostMapping("forma_pago/create")
    public ResponseEntity<Forma_Pago> createForma_Pago(@RequestBody CrearForma_Pago crearForma_Pago){
        Forma_Pago forma_pago = new Forma_Pago();
        forma_pago.setTipo_pago(crearForma_Pago.getTipo_pago());

        forma_pagoServicio.save(forma_pago);
        return ResponseEntity.ok(forma_pago);
    }

    @DeleteMapping("forma_pago/eliminar/{codigo}")
    public ResponseEntity<String> eliminarForma_Pago(@PathVariable Long codigo){

        forma_pagoServicio.delete(codigo);
        return ResponseEntity.ok("ok");
    }

    @PutMapping("forma_pago/actualizar")
    public ResponseEntity<String> actualizarForma_Pago(@RequestBody ActualizarForma_Pago actualizarForma_Pago){
        Optional<Forma_Pago> forma_pagoOptional = forma_pagoServicio.findByCodigo(actualizarForma_Pago.getCodigo());

        Forma_Pago forma_pagoEncontrada = forma_pagoOptional.get();
        forma_pagoEncontrada.setTipo_pago(actualizarForma_Pago.getTipo_pago());

        forma_pagoServicio.save(forma_pagoEncontrada);
        return ResponseEntity.ok("Forma_Pago Actualizada");

    }
}
