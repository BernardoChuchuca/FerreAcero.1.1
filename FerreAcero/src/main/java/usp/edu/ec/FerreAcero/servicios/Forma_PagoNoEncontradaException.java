package usp.edu.ec.FerreAcero.servicios;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason ="Forma_Pago no encontrada")
public class Forma_PagoNoEncontradaException extends RuntimeException{
    public Forma_PagoNoEncontradaException(){
    }

    public Forma_PagoNoEncontradaException(String message){
        super(message);
    }
}
