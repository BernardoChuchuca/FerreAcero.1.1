package usp.edu.ec.FerreAcero.repositorios;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import usp.edu.ec.FerreAcero.entidades.Persona;
import usp.edu.ec.FerreAcero.entidades.TarjetaCredito;

public interface TarjetaRepositorio extends CrudRepository<TarjetaCredito, Integer> {

    @Query("Select t from TarjetaCredito t where t.CCV= :CCV")
    TarjetaCredito findTarjetaCreditoByCodigo(int CCV);


    @Query("Select t from TarjetaCredito t where t.tipoTarjeta= :tipoTarjeta")
    TarjetaCredito findTarjetaCreditoByTipoTarjeta(String tipoTarjeta);

    @Query("Delete from TarjetaCredito t where t.id= :id")
    Persona deletePersonaByCedula(int id);


}
