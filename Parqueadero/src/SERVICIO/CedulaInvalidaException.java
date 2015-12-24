/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SERVICIO;

/**
 *
 * @author gube
 */
public class CedulaInvalidaException extends Exception {

    private String mensaje;
    public CedulaInvalidaException(String cedula) {
        this.mensaje=cedula;
    }

    CedulaInvalidaException() {
        
    }

    /**
     * @return the mensaje
     */
    public String getMensaje() {
        return mensaje;
    }
    
}
