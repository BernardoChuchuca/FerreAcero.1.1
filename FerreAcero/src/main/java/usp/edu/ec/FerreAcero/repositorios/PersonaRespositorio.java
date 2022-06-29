package usp.edu.ec.FerreAcero.repositorios;

import usp.edu.ec.FerreAcero.entidades.Persona;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface PersonaRespositorio extends CrudRepository<Persona,Long> {
    @Query("Select p.nombre,p.codigo from Persona p where p.codigo= :codigo")
    String findPersonaByCodigo(long codigo);



    @Query("Select p from Persona p where p.cedula= :cedula")
    Persona findPersonaByCedula(String cedula);


    @Query("Delete from Persona p where p.cedula= :cedula")
    Persona deletePersonaByCedula(String cedula);
}
