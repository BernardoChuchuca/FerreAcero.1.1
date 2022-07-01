package usp.edu.ec.FerreAcero.controladores;

import usp.edu.ec.FerreAcero.entidades.Persona;
import usp.edu.ec.FerreAcero.entidades.TarjetaCredito;

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


}
