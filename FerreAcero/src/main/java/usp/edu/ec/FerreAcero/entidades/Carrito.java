package usp.edu.ec.FerreAcero.entidades;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
public class Carrito implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int numero;
    private Date fecha;
    @ManyToOne
    @JoinColumn
    private Persona persona;

    public Carrito(int id, int numero, Date fecha, Persona persona) {
        this.id = id;
        this.numero = numero;
        this.fecha = fecha;
        this.persona = persona;
    }

    public Carrito() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Carrito carrito = (Carrito) o;
        return id == carrito.id && numero == carrito.numero && Objects.equals(fecha, carrito.fecha) && Objects.equals(persona, carrito.persona);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, numero, fecha, persona);
    }

    @Override
    public String toString() {
        return "Carrito{" +
                "id=" + id +
                ", numero=" + numero +
                ", fecha=" + fecha +
                ", persona=" + persona +
                '}';
    }
}

