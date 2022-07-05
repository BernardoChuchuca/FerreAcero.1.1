package usp.edu.ec.FerreAcero.entidades.peticiones.pedidodetalle;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CrearPedidoDetalle {

    @JsonProperty
    private double subtotal;

    @JsonProperty
    private double total;


    public double getSubtotal() {
        return subtotal;
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
}
