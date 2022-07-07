package usp.edu.ec.FerreAcero.entidades.peticiones.pedido;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CrearPedido {

    @JsonProperty
    private int numero;

    @JsonProperty
    private String estado;

    @JsonProperty
    private double total;

    @JsonProperty
    private int persona_id;

    @JsonProperty
    private int carrito_id;

    @JsonProperty
    private int pedidodetalle_id;

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getPersona_id() {
        return persona_id;
    }

    public void setPersona_id(int persona_id) {
        this.persona_id = persona_id;
    }

    public int getCarrito_id() {
        return carrito_id;
    }

    public void setCarrito_id(int carrito_id) {
        this.carrito_id = carrito_id;
    }

    public int getPedidodetalle_id() {
        return pedidodetalle_id;
    }

    public void setPedidodetalle_id(int pedidodetalle_id) {
        this.pedidodetalle_id = pedidodetalle_id;
    }
}
