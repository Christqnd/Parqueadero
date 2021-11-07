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
public class NombreIvalidoException extends Exception {
    private String mensaje;

    public NombreIvalidoException(String nombre) {
        this.mensaje=nombre;
    }

    /**
     * @return the mensaje
     */
    public String getMensaje() {
        return mensaje;
    }

    
    
}
