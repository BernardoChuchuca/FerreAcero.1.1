package usp.edu.ec.FerreAcero.controladores;


import usp.edu.ec.FerreAcero.entidades.*;


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


    public  List<Producto> productoCate911 (Categoria categoria,List<Producto> listasPC){
        List<Producto> nombresPC = new ArrayList<>();

        for (int i=0; i < listasPC.size();i++){
            if (categoria.getId()==listasPC.get(i).getCategoria().getId()){

                Producto p2 = new Producto();

                p2.setNombre(listasPC.get(i).getNombre());
                p2.setMarca(listasPC.get(i).getMarca());
                p2.setPrecio(listasPC.get(i).getPrecio());

                nombresPC.add(p2);

            }

        }

        return nombresPC;
    }

    public String CalcularDistancia(Sucursal sucursal2, Direccion dir) {

        double latS=Double.parseDouble(sucursal2.getLatitud());
        double lonS=Double.parseDouble(sucursal2.getLongitud());

        double latD=dir.getLatitud();
        double lonD=dir.getLongitud();

        double R=6378;

        double c = (Math.PI)/180;

        double d=2*R*Math.asin(Math.sqrt(Math.pow(Math.sin(c*(latD-latS)/2),2)+Math.cos(c*latS)*Math.cos(c*latD)*Math.pow(Math.sin(c*(lonD-lonS)/2),2)));
        String dis=String.valueOf((d/10000)).concat(" KM");
        return dis;

    }





    public  List<Producto> sucurProducto911 (Sucursal sucursal,List<Producto> listasP2){
        List<Producto> nombresP2 = new ArrayList<>();

        for (int i=0; i < listasP2.size();i++){
            if (sucursal.getId()==listasP2.get(i).getSucursal().getId()){
                Producto p1 = new Producto();

                p1.setNombre(listasP2.get(i).getNombre());
                p1.setMarca(listasP2.get(i).getMarca());
                p1.setPrecio(listasP2.get(i).getPrecio());

                nombresP2.add(p1);

            }

        }

        return nombresP2;
    }




}
