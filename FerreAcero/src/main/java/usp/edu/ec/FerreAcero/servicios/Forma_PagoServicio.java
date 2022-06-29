package usp.edu.ec.FerreAcero.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import usp.edu.ec.FerreAcero.entidades.Forma_Pago;
import usp.edu.ec.FerreAcero.repositorios.Forma_PagoRepositorio;

import java.util.List;
import java.util.Optional;

@Service
public class Forma_PagoServicio {
    @Autowired
    private Forma_PagoRepositorio forma_pagoRepositoreo;

    public List<Forma_Pago> findAll(){
        return (List<Forma_Pago>)forma_pagoRepositoreo.findAll();
    }

    public String retrieveForma_PagoTipo_PagoByCodigo(Long codigo){
        return (String) forma_pagoRepositoreo.findForma_PagoTipo_PagosByCodigo(codigo);
    }

    public List<String>retriveAllTipo_Pagos(){
        return(List<String>)forma_pagoRepositoreo.findAllTipo_Pagos();
    }

    public Forma_Pago retriveForma_PagoByTipo_Pago(String tipo_pago){
        return (Forma_Pago) forma_pagoRepositoreo.findForma_PagoByTipo_Pago(tipo_pago);
    }

    public void save(Forma_Pago forma_pago){
        forma_pagoRepositoreo.save(forma_pago);
    }

    public void delete(Long codigo){
        forma_pagoRepositoreo.deleteById(codigo);
    }

    //Actualizar Forma_Pago
    public Optional<Forma_Pago> findByCodigo(long codigo){
        return (Optional<Forma_Pago>)  forma_pagoRepositoreo.findById(codigo);
    }
}