/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SERVICIO;

import MODELO.Portero;
import MODELO.Puerta;

/**
 *
 * @author gube
 */
public class PorteroSERVICIO {
    
    
    public Portero crearPortero(String nombre,String apellido,String cedula,Puerta p) throws NombreIvalidoException, ApellidoInvalidoException, CedulaInvalidaException, PuertaInvalidaException{
        if(nombre.length()==0 || nombre==null)
            throw new NombreIvalidoException(nombre);
        if(apellido.length()==0 || apellido==null)
            throw new ApellidoInvalidoException();
        if(cedula.length()!=10 || cedula==null)
            throw new CedulaInvalidaException();
        
        if(p==null)
            throw new PuertaInvalidaException();
        
        
        return new Portero(nombre, apellido, cedula, apellido, null, null);
        
    }
}
