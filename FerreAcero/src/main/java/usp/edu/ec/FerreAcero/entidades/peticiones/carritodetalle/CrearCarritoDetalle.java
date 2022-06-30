package usp.edu.ec.FerreAcero.entidades.peticiones.carritodetalle;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CrearCarritoDetalle {

    @JsonProperty
    private double valor_unitario;
    @JsonProperty
    private int cantidad;

    public double getValor_unitario() {
        return valor_unitario;
    }

    public void setValor_unitario(double valor_unitario) {
        this.valor_unitario = valor_unitario;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
