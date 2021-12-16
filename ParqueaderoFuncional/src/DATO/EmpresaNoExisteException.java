/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DATO;

/**
 *
 * @author pablopc
 */
public class EmpresaNoExisteException extends Exception {
    public String mensaje;

    public EmpresaNoExisteException(String m) {
        this.mensaje=m;
    }
    
}
