package usp.edu.ec.FerreAcero.entidades.peticiones.carrito;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class ActualizarCarrito {
    @JsonProperty
    private int id;
    @JsonProperty
    private int numero;
    @JsonProperty
    private Date fecha;

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
}
