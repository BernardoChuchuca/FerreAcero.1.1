package usp.edu.ec.FerreAcero.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import usp.edu.ec.FerreAcero.entidades.Carrito;
import usp.edu.ec.FerreAcero.entidades.Pedido;
import usp.edu.ec.FerreAcero.entidades.Persona;
import usp.edu.ec.FerreAcero.entidades.Usuario;
import usp.edu.ec.FerreAcero.entidades.peticiones.Usuario.ActualizarUsuario;
import usp.edu.ec.FerreAcero.entidades.peticiones.Usuario.CrearUsuario;
import usp.edu.ec.FerreAcero.entidades.peticiones.carrito.ActualizarCarrito;
import usp.edu.ec.FerreAcero.entidades.peticiones.carrito.CrearCarrito;
import usp.edu.ec.FerreAcero.servicios.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UsuarioControlador {

    private UsuarioServicio usuarioServicio;

    private PersonaServicio personaServicio;

    private  PedidoControlador pedidoControlador;
    Gestion ges=new Gestion();

    @Autowired
    public void setPersonaServicio(PersonaServicio personaServicio) {
        this.personaServicio = personaServicio;
    }

    @Autowired
    public void setUsuarioServicio(UsuarioServicio usuarioServicio) {
        this.usuarioServicio = usuarioServicio;
    }

    @GetMapping("/Usuarios")
    public ResponseEntity<List<Usuario>> getAllUsuario(){

        List<Usuario> listaUsuario=usuarioServicio.findAll();

        return new ResponseEntity<>(listaUsuario, HttpStatus.OK);
    }
@Autowired
    public void setPedidoControlador(PedidoControlador pedidoControlador) {
        this.pedidoControlador = pedidoControlador;
    }

    @PostMapping("usuario/create")
    public ResponseEntity<String> crearUsuario(@RequestBody CrearUsuario crearUsuario){
        Optional<Persona> persona = personaServicio.findByCodigo(crearUsuario.getPersona_id());
        Optional<Usuario> usuarioO = usuarioServicio.findById(crearUsuario.getPersona_id());


        if(persona.isEmpty()){
            return ResponseEntity.ok("Cliente no existe");
        }else{

            if(usuarioO.isEmpty()){
                Usuario usuario =new Usuario();
                usuario.setUsuario(crearUsuario.getUsuario());
                usuario.setClave(crearUsuario.getClave());
                usuario.setPersona(persona.get());
                usuarioServicio.save(usuario);
                return ResponseEntity.ok("Usuario Registrado");
            }else{

                return ResponseEntity.ok("Usuario ya existente");


            }


        }




    }

    @PutMapping("usuario/editar")
    public ResponseEntity<String>editarCarrito(@RequestBody ActualizarUsuario actualizarUsuario){
        Optional<Usuario> usuarioO = usuarioServicio.findById(actualizarUsuario.getId());

        if(usuarioO.isEmpty()){
            return ResponseEntity.badRequest().build();
        }

        Usuario usuarion=usuarioO.get();
        usuarion.setUsuario(actualizarUsuario.getUsuario());
        usuarion.setId(actualizarUsuario.getId());
        usuarion.setClave(actualizarUsuario.getClave());
        usuarioServicio.save(usuarion);

        return ResponseEntity.ok("Usuario Actualizado");
    }

    @DeleteMapping("/usuario/delete/{id}")

    public ResponseEntity<String>deleteusuario(@PathVariable int id){

        usuarioServicio.delete(id);

        return ResponseEntity.ok("Usuario Eliminado");


    }

    @GetMapping("/usuario/iniciar/{usuario}/{clave}")

    public ResponseEntity<String>IniciarSesion(@PathVariable String usuario,@PathVariable String clave){



        Optional<Usuario> usuario1 = Optional.ofNullable(usuarioServicio.iniSesion(clave,usuario));


        if(!usuario1.isEmpty()){

            ges.setId_persona(usuario1.get().getPersona().getId());

            pedidoControlador.Resx(ges);

            return ResponseEntity.ok("Inicio de Sesion Correcto");

        }else{

            return ResponseEntity.ok("Inicio de Sesion Incorrecto");
        }




    }

}