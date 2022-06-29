package usp.edu.ec.FerreAcero.entidades;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long codigo;

    private String cedula;
    private String nombre;
    private String apellidos;

    private int edad;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "persona",cascade = CascadeType.ALL)


    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public int getEdad() {
        return edad;
    }

    public long getCodigo() {
        return codigo;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getCedula() {
        return cedula;
    }

    public String getNombre() {
        return nombre;
    }





    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Persona)) return false;
        Persona persona = (Persona) o;
        return codigo == persona.codigo && edad == persona.edad && Objects.equals(cedula, persona.cedula) && Objects.equals(nombre, persona.nombre) && Objects.equals(apellidos, persona.apellidos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo, cedula, nombre, apellidos, edad);
    }

    @Override
    public String toString() {
        return "Persona{" +
                "codigo=" + codigo +
                ", cedula='" + cedula + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", edad=" + edad +
                '}';
    }
}
