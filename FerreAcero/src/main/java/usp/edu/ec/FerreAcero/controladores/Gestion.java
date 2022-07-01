package usp.edu.ec.FerreAcero.controladores;

import usp.edu.ec.FerreAcero.entidades.Categoria;
import usp.edu.ec.FerreAcero.entidades.Producto;
import usp.edu.ec.FerreAcero.entidades.Sucursal;

import java.util.ArrayList;
import java.util.List;

public class Gestion {

    public  List<String> sucurNombre ( List<Sucursal> listas){
        List<String> nombres = new ArrayList<>();
        for (int i=0; i < listas.size();i++){
            nombres.add(listas.get(i).getNombre());
        }

        return nombres;
    }


    public  List<String> categoriaNombre ( List<Categoria> listasC){
        List<String>  nombresC= new ArrayList<>();
        for (int i=0; i < listasC.size();i++){
            nombresC.add(listasC.get(i).getNombre());
        }

        return nombresC;
    }



    public  List<String> sucurProducto (Sucursal sucursal,List<Producto> listasP){
        List<String> nombresP = new ArrayList<>();

        for (int i=0; i < listasP.size();i++){
            if (sucursal.getId()==listasP.get(i).getSucursal().getId()){

                nombresP.add(listasP.get(i).getNombre());
            }

        }

        return nombresP;
    }

    public  List<String> productoCate (Categoria categoria,List<Producto> listasPC){
        List<String> nombresPC = new ArrayList<>();

        for (int i=0; i < listasPC.size();i++){
            if (categoria.getId()==listasPC.get(i).getCategoria().getId()){

                nombresPC.add(listasPC.get(i).getNombre());
            }

        }

        return nombresPC;
    }

}
