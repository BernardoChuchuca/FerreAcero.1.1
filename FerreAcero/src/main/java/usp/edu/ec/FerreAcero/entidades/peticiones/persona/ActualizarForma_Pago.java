package usp.edu.ec.FerreAcero.entidades.peticiones.persona;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ActualizarForma_Pago {
    @JsonProperty
    private Long codigo;
    @JsonProperty
    private String tipo_pago;

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getTipo_pago() {
        return tipo_pago;
    }

    public void setTipo_pago(String tipo_pago) {
        this.tipo_pago = tipo_pago;
    }
}
