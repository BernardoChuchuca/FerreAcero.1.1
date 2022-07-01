package usp.edu.ec.FerreAcero.controladores;


import usp.edu.ec.FerreAcero.entidades.Persona;
import usp.edu.ec.FerreAcero.entidades.TarjetaCredito;

import usp.edu.ec.FerreAcero.entidades.Categoria;
import usp.edu.ec.FerreAcero.entidades.Producto;
import usp.edu.ec.FerreAcero.entidades.Sucursal;


import java.util.ArrayList;
import java.util.List;

public class Gestion {


    public List<TarjetaCredito>listatajetas(List<TarjetaCredito>tarjetaCreditos,String cedula){

        List<TarjetaCredito>listatajetas=new ArrayList<>();


        for (int i=0;i<tarjetaCreditos.size();i++) {

            if (tarjetaCreditos.get(i).getPersona().getCedula().equals(cedula)) {
                TarjetaCredito tar = new TarjetaCredito();

                tar.setId(tarjetaCreditos.get(i).getId());
                tar.setCCV(tarjetaCreditos.get(i).getCCV());
                tar.setFechaExp(tarjetaCreditos.get(i).getFechaExp());
                tar.setNumeroTarjeta(tarjetaCreditos.get(i).getNumeroTarjeta());
                tar.setTipoTarjeta(tarjetaCreditos.get(i).getTipoTarjeta());
                tar.setPersona(tarjetaCreditos.get(i).getPersona());

                listatajetas.add(tar);


            }
        }
        return listatajetas;
    }



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
