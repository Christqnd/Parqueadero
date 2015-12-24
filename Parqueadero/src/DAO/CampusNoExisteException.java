/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

/**
 *
 * @author pablopc
 */
public class CampusNoExisteException extends Exception {
    public String mensaje;

    public CampusNoExisteException(String m) {
        this.mensaje=m;
    }
    
}
