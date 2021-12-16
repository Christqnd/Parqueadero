/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SERVICIO;

import MODELO.Parqueadero;
import MODELO.Puerta;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gube
 */
public class ParqueaderosSERVICIO {
    private static ParqueaderosSERVICIO instancia=null;
    
    private boolean modificar=false;
    private Parqueadero parqueadero;
    private List<Puerta> puertasentrada=new ArrayList<>();
    private List<Puerta> puertassalida=new ArrayList<>();
    
    private ParqueaderosSERVICIO() {
    }
    
    public void nuevasListas(){
        this.puertasentrada.clear();
        this.puertassalida.clear();
    }
    public static ParqueaderosSERVICIO getInstancia(){
        if(instancia==null)
            instancia=new ParqueaderosSERVICIO();
        return instancia;
    }
    
    
    public Parqueadero crearParqueadero(String codigo,int numero,int capacidad) throws ParqueaderoVacioException, CodigoInvalidoExcetion, CapacidadInvalidaException, NumeroParqueaderoInvalido{
        
        if(codigo.length()==0 || codigo==null){
            throw new CodigoInvalidoExcetion();
        }
        if(numero<=0){
            throw new NumeroParqueaderoInvalido();
        }
        if(capacidad<=0)
            throw new CapacidadInvalidaException();
        
        
        if(this.puertasentrada.isEmpty() || this.puertassalida.isEmpty())
            throw new ParqueaderoVacioException();
        
        this.setParqueadero(new Parqueadero());
        getParqueadero().setCodigo(codigo);
        getParqueadero().setNumero(numero);
        getParqueadero().setCapacidad(capacidad);
        getParqueadero().setOcupados(0);
        this.agregarPuertas();
//        getParqueadero().getPuertas().addAll(puertasentrada);
//        getParqueadero().getPuertas().addAll(puertassalida);
       
       return this.getParqueadero();
       
    }
    
     public void agregarPuertas(){
         List<Puerta> lista=new ArrayList<>();
        for(int i=0;i<puertasentrada.size();i++){
            if(this.buscarPuerta(this.puertasentrada.get(i).getCodigo(), lista)<0){
                lista.add(this.puertasentrada.get(i));
            }
        }
    
        for(int i=0;i<puertassalida.size();i++){
            if(this.buscarPuerta(this.puertassalida.get(i).getCodigo(), lista)<0){
                lista.add(this.puertassalida.get(i));
            }
        }
        getParqueadero().getPuertas().addAll(lista);
    }
    
    
    public Puerta obtenerPuertaEntrada(String codigo){
        Puerta p = null;
        for(int i=0;i<this.puertasentrada.size();i++){
            if(this.puertasentrada.get(i).getCodigo().equalsIgnoreCase(codigo)){
                if(this.puertasentrada.get(i).getTipoDePuerta().estadoPuerta().equalsIgnoreCase("entrada/salida")){
                    this.puertassalida.remove(this.buscarPuerta(codigo, puertassalida));
                }
                p=this.puertasentrada.get(i);
                this.puertasentrada.remove(i);
                i=this.puertasentrada.size()+1;
            }
        }
        return p;
    }
    
        public Puerta obtenerPuertaSalida(String codigo){
        Puerta p = null;
        for(int i=0;i<this.puertassalida.size();i++){
            if(this.puertassalida.get(i).getCodigo().equalsIgnoreCase(codigo)){
                if(this.puertassalida.get(i).getTipoDePuerta().estadoPuerta().equalsIgnoreCase("entrada/salida")){
                    this.puertasentrada.remove(this.buscarPuerta(codigo, puertasentrada));
                }
                p=this.puertassalida.get(i);
                this.puertassalida.remove(i);
                i=this.puertassalida.size()+1;
            }
        }
        return p;
    }
    public void agregarPuertaentrada(Puerta p){
        this.puertasentrada.add(p);
        if(p.getTipoDePuerta().estadoPuerta().equalsIgnoreCase("entrada/salida"))
            this.puertassalida.add(p);
    }  

    public void agregarPuertaSalida(Puerta p){
        this.puertassalida.add(p);
        if(p.getTipoDePuerta().estadoPuerta().equalsIgnoreCase("entrada/salida"))
            this.puertasentrada.add(p);
    }
    
    
       public int buscarPuerta(String codigo,List<Puerta> lista){
       int valor=-1;
       for(int i=0;i<lista.size();i++){
           if(lista.get(i).getCodigo().equalsIgnoreCase(codigo)){
               valor=i;
               i+=lista.size();
           }
       }
       return valor;
   }
    /**
     * @return the puertasentrada
     */
    public List<Puerta> getPuertasentrada() {
        return puertasentrada;
    }

    
    /**
     * @return the puertassalida
     */
    public List<Puerta> getPuertassalida() {
        return puertassalida;
    }

    public void limpiarlistas() {
        
        this.puertasentrada.clear();
        this.puertassalida.clear();
    }

    /**
     * @return the parqueadero
     */
    public Parqueadero getParqueadero() {
        return parqueadero;
    }

    /**
     * @param parqueadero the parqueadero to set
     */
    public void setParqueadero(Parqueadero parqueadero) {
        this.parqueadero = parqueadero;
    }

    /**
     * @return the modificar
     */
    public boolean isModificar() {
        return modificar;
    }

    /**
     * @param modificar the modificar to set
     */
    public void setModificar(boolean modificar) {
        this.modificar = modificar;
    }

    public void cargarParqueadero(String codigo) {
        this.parqueadero=EmpresaSERVICIO.getInstancia().getCampus().obtener(codigo);
        List<Puerta> lista=this.parqueadero.getPuertas();
        PuertasSERVICIO.getInstancia().separarListas();
        int a=0;
        for(Puerta p:lista){
            
            if(p.getTipoDePuerta().estadoPuerta().equalsIgnoreCase("entrada")){
                this.agregarPuertaentrada(p);
                PuertasSERVICIO.getInstancia().obtenerPuertaentrada(p.getCodigo());
            }
            else if(p.getTipoDePuerta().estadoPuerta().equalsIgnoreCase("salida")){
                this.agregarPuertaSalida(p);
                PuertasSERVICIO.getInstancia().obtenerPuertasalida(p.getCodigo());
            }
            else if(p.getTipoDePuerta().estadoPuerta().equalsIgnoreCase("entrada/salida")){
                
                if(a==0){                    
                    this.agregarPuertaSalida(p);                
                    PuertasSERVICIO.getInstancia().obtenerPuertasalida(p.getCodigo());
                    a=1;
                }else if(a==1){
                    this.agregarPuertaentrada(p);
                    PuertasSERVICIO.getInstancia().obtenerPuertaentrada(p.getCodigo());
                    a=0;
                }
            }
        }
    }
    
    

    
}
