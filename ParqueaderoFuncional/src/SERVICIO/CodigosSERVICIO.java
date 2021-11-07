/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SERVICIO;

import java.util.Random;

/**
 *
 * @author pablopc
 */
public class CodigosSERVICIO {
    
    private static CodigosSERVICIO instancia=null;

    private CodigosSERVICIO() {
    }
    
    public static CodigosSERVICIO getInstancia(){
        if(instancia==null)
            instancia=new CodigosSERVICIO();
        return instancia;
    }
    
        public String generarCodigo(String prefijo){
        String cadenaAleatoria = "";
        long milis = new java.util.GregorianCalendar().getTimeInMillis();
        Random r = new Random(milis);
        int i = 0;
        while ( i < 10){
        char c = (char)r.nextInt(255);
        if ( (c >= '0' && c <='9') || (c >='A' && c <='Z') ){
        cadenaAleatoria += c;
        i ++;
        }
        }
        return prefijo+"-"+cadenaAleatoria;
    }
}
