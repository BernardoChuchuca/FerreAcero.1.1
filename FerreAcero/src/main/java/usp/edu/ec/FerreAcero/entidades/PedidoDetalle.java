package usp.edu.ec.FerreAcero.entidades;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class PedidoDetalle {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private double total;

    private double subtotal;


    @OneToOne
    @JoinColumn
    private Producto producto;

    public PedidoDetalle() {
    }

    public PedidoDetalle(int id, double total, double subtotal, Producto producto) {
        this.id = id;
        this.total = total;
        this.subtotal = subtotal;
        this.producto = producto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getTotal(double total) {
        return this.total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
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
        PedidoDetalle that = (PedidoDetalle) o;
        return id == that.id && Double.compare(that.total, total) == 0 && Double.compare(that.subtotal, subtotal) == 0 && producto.equals(that.producto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, total, subtotal, producto);
    }

    @Override
    public String toString() {
        return "PedidoDetalle{" +
                "id=" + id +
                ", total=" + total +
                ", subtotal=" + subtotal +
                ", producto=" + producto +
                '}';
    }
}
