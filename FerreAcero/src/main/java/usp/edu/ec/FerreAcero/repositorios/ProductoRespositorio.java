package usp.edu.ec.FerreAcero.repositorios;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import usp.edu.ec.FerreAcero.entidades.Producto;

public interface ProductoRespositorio extends CrudRepository<Producto, Integer> {
    @Query("Select p.nombre,p.id from Producto p where p.id= :id")
    String findProductoByCodigo(int id);



    @Query("Select p from Producto p where p.nombre= :nombre")
    Producto findProductoByNombre(String nombre);


    /*@Query("Delete from Producto p where p.id= :id")
    Producto deletePersonaByCedula(int id);*/
}
