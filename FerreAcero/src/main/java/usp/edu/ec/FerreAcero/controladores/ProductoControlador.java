package usp.edu.ec.FerreAcero.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import usp.edu.ec.FerreAcero.entidades.Producto;

import usp.edu.ec.FerreAcero.servicios.ProductoServicio;

import java.util.List;
import java.util.Optional;
@RestController
public class ProductoControlador {

    private ProductoServicio productoServicio;

    @Autowired
    public void setProductoServicio(ProductoServicio productoServicio) {

        this.productoServicio = productoServicio;
    }

    @GetMapping("/productos")
    public ResponseEntity<List<Producto>>getAllProducto(){

        List<Producto> listaProducto=productoServicio.findAll();

        //return new ResponseEntity<List<Producto>>(listaProducto, HttpStatus.OK);
        return  new ResponseEntity<List<Producto>>(listaProducto,HttpStatus.OK);

    }

    /*@GetMapping("{codigo}/nombre")

    public ResponseEntity<String> Consulta (@PathVariable int codigo){
        String nombre = personaServicio.ConsultaDatos(codigo);

        return new ResponseEntity<String>(nombre,HttpStatus.OK);

    }

    @GetMapping("/persona/{cedula}")

    public ResponseEntity<Persona> getPersona (@PathVariable String cedula) throws PersonaExeption {
        Optional<Persona> persona = Optional.ofNullable(personaServicio.ConsultaDatosP(cedula));
        Persona persona1=persona.orElseThrow(PersonaExeption::new);

        return new ResponseEntity<Persona>(persona1,HttpStatus.OK);

    }


    @PostMapping("/persona/create")
    public ResponseEntity<Persona> createPersona (@RequestBody Crear_Persona crear_persona){
        Persona persona = new Persona();
        persona.setCedula(crear_persona.getCedula());
        persona.setNombre(crear_persona.getNombre());
        persona.setApellido(crear_persona.getApellido());
        persona.setEmail(crear_persona.getEmail());
        persona.setClave(crear_persona.getClave());
        persona.setDireccion(crear_persona.getDireccion());
        persona.setTelefono(crear_persona.getTelefono());
        persona.setTipo(crear_persona.getTipo());
        personaServicio.save(persona);

        return ResponseEntity.ok(persona);
    }




   /* @GetMapping("/persona/{cedula}")

    public ResponseEntity<Persona> getPersona (@PathVariable String cedula)  {
        Persona persona = personaServicio.ConsultaDatosP(cedula);

        return new ResponseEntity<Persona>(persona,HttpStatus.OK);

    }

    @PutMapping("/persona/update")
    public ResponseEntity<String>updatePersona(@RequestBody ActualizarPersona actualizarPersona) {

        Optional<Persona> personaOptional = personaServicio.findByCodigo(actualizarPersona.getId());

        if (personaOptional.isEmpty()) {


            return ResponseEntity.badRequest().build();


        }

        Persona personae=personaOptional.get();

        personae.setId(actualizarPersona.getId());
        personae.setNombre(actualizarPersona.getNombre());
        personae.setApellido(actualizarPersona.getApellido());
        personae.setCedula(actualizarPersona.getCedula());
        personae.setTelefono(actualizarPersona.getTelefono());
        personae.setDireccion(actualizarPersona.getDireccion());
        personae.setClave(actualizarPersona.getClave());
        personae.setEmail(actualizarPersona.getEmail());
        personae.setTipo(actualizarPersona.getTipo());
        personaServicio.save(personae);

        return ResponseEntity.ok("Persona Actulizada");
    }

    @DeleteMapping("/persona/delete/{id}")

    public ResponseEntity<String>deletepersona(@PathVariable int id){

        personaServicio.delete(id);

        return ResponseEntity.ok("Persona Eliminada");


    }*/

}
