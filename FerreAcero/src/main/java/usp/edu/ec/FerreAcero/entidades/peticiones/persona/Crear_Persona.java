package usp.edu.ec.FerreAcero.entidades.peticiones.persona;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Crear_Persona {
    @JsonProperty
    private String cedula;
    @JsonProperty
    private String nombre;
    @JsonProperty
    private String apellidos;
    @JsonProperty
    private int edad;

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
}
