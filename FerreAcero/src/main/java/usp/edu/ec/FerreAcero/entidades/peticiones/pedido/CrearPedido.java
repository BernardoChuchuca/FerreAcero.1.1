package usp.edu.ec.FerreAcero.entidades.peticiones.pedido;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CrearPedido {

    @JsonProperty
    private int numero;
    @JsonProperty
    private int persona_id;
    @JsonProperty
    private int producto_id;
    @JsonProperty
    private int carrito_id;

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getPersona_id() {
        return persona_id;
    }

    public void setPersona_id(int persona_id) {
        this.persona_id = persona_id;
    }

    public int getProducto_id() {
        return producto_id;
    }

    public void setProducto_id(int producto_id) {
        this.producto_id = producto_id;
    }

    public int getCarrito_id() {
        return carrito_id;
    }

    public void setCarrito_id(int carrito_id) {
        this.carrito_id = carrito_id;
    }
}
