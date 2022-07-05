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

    @ManyToOne
    @JoinColumn
    private Pedido pedido;

    @OneToOne
    @JoinColumn
    private CarritoDetalle carritoDetalle;

    public PedidoDetalle() {
    }

    public PedidoDetalle(int id, double total, double subtotal, Producto producto, Pedido pedido, CarritoDetalle carritoDetalle) {
        this.id = id;
        this.total = total;
        this.subtotal = subtotal;
        this.producto = producto;
        this.pedido = pedido;
        this.carritoDetalle = carritoDetalle;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getTotal() {
        return total;
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

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public CarritoDetalle getCarritoDetalle() {
        return carritoDetalle;
    }

    public void setCarritoDetalle(CarritoDetalle carritoDetalle) {
        this.carritoDetalle = carritoDetalle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PedidoDetalle that = (PedidoDetalle) o;
        return id == that.id && Double.compare(that.total, total) == 0 && Double.compare(that.subtotal, subtotal) == 0 && producto.equals(that.producto) && pedido.equals(that.pedido) && carritoDetalle.equals(that.carritoDetalle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, total, subtotal, producto, pedido, carritoDetalle);
    }

    @Override
    public String toString() {
        return "PedidoDetalle{" +
                "id=" + id +
                ", total=" + total +
                ", subtotal=" + subtotal +
                ", producto=" + producto +
                ", pedido=" + pedido +
                ", carritoDetalle=" + carritoDetalle +
                '}';
    }
}
