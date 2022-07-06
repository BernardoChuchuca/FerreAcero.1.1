package usp.edu.ec.FerreAcero.entidades.peticiones.pedidodetalle;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CrearPedidoDetalle {

    @JsonProperty
    private int cantidad;

    @JsonProperty
    private double subtotal;

    @JsonProperty
    private double total;

    @JsonProperty
    private int producto_id;

    @JsonProperty
    private int carritodetalle_id;

    @JsonProperty
    private int pedido_id;

    public double getSubtotal() {
        return subtotal;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getProducto_id() {
        return producto_id;
    }

    public void setProducto_id(int producto_id) {
        this.producto_id = producto_id;
    }

    public int getCarritodetalle_id() {
        return carritodetalle_id;
    }

    public void setCarritodetalle_id(int carritodetalle_id) {
        this.carritodetalle_id = carritodetalle_id;
    }

    public int getPedido_id() {
        return pedido_id;
    }

    public void setPedido_id(int pedido_id) {
        this.pedido_id = pedido_id;
    }
}
