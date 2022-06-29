package usp.edu.ec.FerreAcero.entidades;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "forma_pago")
public class Forma_Pago {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long codigo;

    private String tipo_pago;

    public Forma_Pago() {
    }

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public String getTipo_pago() {
        return tipo_pago;
    }

    public void setTipo_pago(String tipo_pago) {
        this.tipo_pago = tipo_pago;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Forma_Pago that = (Forma_Pago) o;
        return codigo == that.codigo && Objects.equals(tipo_pago, that.tipo_pago);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo, tipo_pago);
    }

    @Override
    public String toString() {
        return "Forma_Pago{" +
                "codigo=" + codigo +
                ", tipo_pago='" + tipo_pago + '\'' +
                '}';
    }
}
