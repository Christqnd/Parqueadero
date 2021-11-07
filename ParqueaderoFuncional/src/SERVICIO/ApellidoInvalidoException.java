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
public class ApellidoInvalidoException extends Exception {

    private String mensaje;
    
    public ApellidoInvalidoException(String apellido) {
        this.mensaje=apellido;
    }

    ApellidoInvalidoException() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * @return the mensaje
     */
    public String getMensaje() {
        return mensaje;
    }
    
}
