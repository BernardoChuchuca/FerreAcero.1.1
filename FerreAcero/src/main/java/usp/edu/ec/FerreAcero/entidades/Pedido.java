package usp.edu.ec.FerreAcero.entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private int numero;

    @ManyToOne
    @JoinColumn
    private Persona persona;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "pedido", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Producto> producto;


    @ManyToOne
    @JoinColumn
    private Carrito carrito;


    public Pedido() {
    }

    public Pedido(int id, int numero, Persona persona, List<Producto> producto, Carrito carrito) {
        this.id = id;
        this.numero = numero;
        this.persona = persona;
        this.producto = producto;
        this.carrito = carrito;
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

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public List<Producto> getProducto() {
        return producto;
    }

    public void setProducto(List<Producto> producto) {
        this.producto = producto;
    }

    public Carrito getCarrito() {
        return carrito;
    }

    public void setCarrito(Carrito carrito) {
        this.carrito = carrito;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pedido pedido = (Pedido) o;
        return id == pedido.id && numero == pedido.numero && persona.equals(pedido.persona) && producto.equals(pedido.producto) && carrito.equals(pedido.carrito);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, numero, persona, producto, carrito);
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "id=" + id +
                ", numero=" + numero +
                ", persona=" + persona +
                ", producto=" + producto +
                ", carrito=" + carrito +
                '}';
    }
}
