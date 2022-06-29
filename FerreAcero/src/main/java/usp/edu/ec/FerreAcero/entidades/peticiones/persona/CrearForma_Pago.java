package usp.edu.ec.FerreAcero.entidades.peticiones.persona;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CrearForma_Pago {
    @JsonProperty
    private String tipo_pago;

    public String getTipo_pago() {
        return tipo_pago;
    }

    public void setTipo_pago(String tipo_pago) {
        this.tipo_pago = tipo_pago;
    }
}
