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
    @ManyToOne
    @JoinColumn
    private Producto producto;

    public Carrito(int id, int numero, Date fecha, Persona persona, Producto producto) {
        this.id = id;
        this.numero = numero;
        this.fecha = fecha;
        this.persona = persona;
        this.producto = producto;
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

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Carrito carrito = (Carrito) o;
        return id == carrito.id && numero == carrito.numero && Objects.equals(fecha, carrito.fecha) && Objects.equals(persona, carrito.persona) && Objects.equals(producto, carrito.producto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, numero, fecha, persona, producto);
    }

    @Override
    public String toString() {
        return "Carrito{" +
                "id=" + id +
                ", numero=" + numero +
                ", fecha=" + fecha +
                ", persona=" + persona +
                ", producto=" + producto +
                '}';
    }
}

