package usp.edu.ec.FerreAcero.entidades.peticiones.persona;

import com.fasterxml.jackson.annotation.JsonIgnore;
import usp.edu.ec.FerreAcero.entidades.Persona;

import javax.persistence.*;

@Entity
public class Rols {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int rol_id;
    private String  rol_nom_rol;
    @OneToOne
    @JoinColumn
    @JsonIgnore
    private Persona persona;

    public Rols() {

    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public int getRol_id() {
        return rol_id;
    }

    public void setRol_id(int rol_id) {
        this.rol_id = rol_id;
    }

    public String getRol_nom_rol() {
        return rol_nom_rol;
    }

    public void setRol_nom_rol(String rol_nom_rol) {
        this.rol_nom_rol = rol_nom_rol;
    }

    public Persona getPersona() {
        return persona;
    }

    public Rols(int rol_id, String rol_nom_rol, Persona persona) {
        this.rol_id = rol_id;
        this.rol_nom_rol = rol_nom_rol;
        this.persona = persona;
    }

    @Override
    public String toString() {
        return "Rols{" +
                "rol_id=" + rol_id +
                ", rol_nom_rol='" + rol_nom_rol + '\'' +
                '}';
    }
}
