package usp.edu.ec.FerreAcero.repositorios;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import usp.edu.ec.FerreAcero.entidades.Forma_Pago;

import java.util.List;

public interface Forma_PagoRepositorio extends CrudRepository<Forma_Pago, Long> {
    @Query("select f.codigo, f.tipo_pago from Forma_Pago f  where f.codigo =:codigo")
    String findForma_PagoTipo_PagosByCodigo(Long codigo);

    @Query("select f.tipo_pago from Forma_Pago f")
    List<String> findAllTipo_Pagos();

    @Query("select f from Forma_Pago f  where f.tipo_pago =:tipo_pago")
    Forma_Pago findForma_PagoByTipo_Pago(String tipo_pago);
}
