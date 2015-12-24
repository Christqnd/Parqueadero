/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SERVICIO;

import DAO.CodigodeCampusNoExisteException;
import DAO.PuertaNoexisteException;
import DAO.PuertasDAO;
import MODELO.Parqueadero;
import MODELO.Portero;
import MODELO.Puerta;
import MODELO.PuertaEntrada;
import MODELO.PuertaEntradaSalida;
import MODELO.PuertaSalida;
import MODELO.StatePuerta;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gube
 */
public class PuertasSERVICIO {
    
    private boolean modificar=false;
    private static PuertasSERVICIO instancia;
    private List<Puerta> listapuertas=new ArrayList<>();
    private List<Puerta> listapuertasentrada=new ArrayList<>();
    private List<Puerta> listapuertasalida=new ArrayList<>();
    private Puerta puerta;

    private PuertasSERVICIO() {
    }
    
    public static PuertasSERVICIO getInstancia(){
        if(instancia==null)
            instancia=new PuertasSERVICIO();
        return instancia;
    }
    
    public void crearPuerta(String numero,String codigo,String ubicacion) throws CodigoInvalidoException, NumeroPuertaInvalidoException, UbicacionInvalidoException{
        if(!validarNumero(numero))
            throw new NumeroPuertaInvalidoException();
        if(!validarDatos(codigo))
            throw new CodigoInvalidoException();
        if(!validarDatos(ubicacion))
            throw new UbicacionInvalidoException();
        
        this.puerta=new Puerta(Integer.parseInt(numero), codigo, ubicacion);
    }
    

    
    public void modificarPuerta(String codigo,String ubicacion,int estado,Portero p) throws UbicacionInvalidoException{
        if(!validarDatos(ubicacion))
            throw new UbicacionInvalidoException();
        int index=this.buscarPuerta(codigo);
        this.listapuertas.get(index).setUbicacion(ubicacion);
        this.listapuertas.get(index).setPortero(p);
        StatePuerta sp = null;
        if(estado==1)
            sp=new PuertaEntrada();
        else if(estado==2)
            sp=new PuertaSalida();
        else if(estado==3)
            sp=new PuertaEntradaSalida();
        this.listapuertas.get(index).setTipoDePuerta(sp);
    }
    public void EstadoPuerta(int a){
        if(a==1)
            this.puerta.setTipoDePuerta(new PuertaEntrada());
        else if(a==2)
            this.puerta.setTipoDePuerta(new PuertaSalida());
        else if(a==3)
            this.puerta.setTipoDePuerta(new PuertaEntradaSalida());
    }
    
    public void cargarPuerta(String codigopuerta) throws CodigodeCampusNoExisteException, PuertaNoexisteException{
        this.puerta=this.listapuertas.get(this.buscarPuerta(codigopuerta));
    }
    
    
    public int buscarPuerta(String codpuerta){
        List <Puerta> lista=this.listapuertas;
        boolean valor=true;
        int i=0;
        while(valor){
            if(lista.get(i).getCodigo().equalsIgnoreCase(codpuerta)){
                valor=false;
            }
            i++;
        }
        if(valor)
            i=-1;
        return i-1;
    }
    public void agregarPuerta(){
        this.getListapuertas().add(this.puerta);
    }
    
    
   
    public void GuardarPuertas(String Codigo){
        for(int i=0;i<listapuertas.size();i++){
            PuertasDAO.getInstancia().AgregarPuerta(Codigo, listapuertas.get(i));
        }
    }
    
    public void guardarNuevasPuertas(String codigo){
        PuertasDAO.getInstancia().getPuertas().get(codigo).clear();
        for(int i=0;i<listapuertas.size();i++){
            PuertasDAO.getInstancia().AgregarPuerta(codigo, listapuertas.get(i));
        }
    }
    
    public void CargarPuertas(String Codigo) throws CodigodeCampusNoExisteException{
        //this.listapuertas.clear();
        List<Puerta> lista=PuertasDAO.getInstancia().obtenerPuertas(Codigo);
        for(Puerta p:lista){
            this.listapuertas.add(p);
        }
    }
    /**
     * retorna verdadero si el dato es valido o falso en caso contrario
     * @param dato
     * @return 
     */
    private boolean validarDatos(String dato){
        if(dato.length()==0 || dato==null)
            return false;
        else
            return true;
    }
    /**
     * retorna true si es numero y falso si no lo es
     * @param numero
     * @return 
     */
    private boolean validarNumero(String numero){
        boolean v=true;
        try {
            int valor=Integer.parseInt(numero);
        } catch (Exception e) {
            v=false;
        }
        
        return v;
    }
    
    public void listaPuertasEntrada(){
        List lista=new ArrayList();
        for(Puerta p:this.listapuertas){
            if(p.getTipoDePuerta().estadoPuerta().equalsIgnoreCase("entrada") || p.getTipoDePuerta().estadoPuerta().equalsIgnoreCase("Entrada/Salida")){
                lista.add(p);
            }
        }
        this.listapuertasentrada=lista;
    }
    
    public void listaPuertasSalida(){
        List lista=new ArrayList();
        for(Puerta p:this.listapuertas){
            if(p.getTipoDePuerta().estadoPuerta().equalsIgnoreCase("salida") || p.getTipoDePuerta().estadoPuerta().equalsIgnoreCase("Entrada/Salida")){
                lista.add(p);
            }
        }
        this.listapuertasalida=lista;
    }
    
   public Puerta obtenerPuertasalida(String codigo){
       Puerta p=null;       
       for(int i=0;i<this.listapuertasalida.size();i++){
           if(this.listapuertasalida.get(i).getCodigo().equalsIgnoreCase(codigo)){
               if(this.listapuertasalida.get(i).getTipoDePuerta().estadoPuerta().equalsIgnoreCase("entrada/salida")){
                   this.listapuertasentrada.remove(this.buscarPuerta(codigo, this.listapuertasentrada));
               }
               p=this.listapuertasalida.get(i);
               this.listapuertasalida.remove(i);
               i=this.listapuertasalida.size()+1;
           }
       }
       return p;
   }
   
   public Puerta obtenerPuertaentrada(String codigo){
       Puerta p=null;
       for(int i=0;i<this.listapuertasentrada.size();i++){
           if(this.listapuertasentrada.get(i).getCodigo().equalsIgnoreCase(codigo)){
               if(this.listapuertasentrada.get(i).getTipoDePuerta().estadoPuerta().equalsIgnoreCase("entrada/salida")){
                   this.listapuertasalida.remove(this.buscarPuerta(codigo, this.listapuertasalida));
               }
               p=this.listapuertasentrada.get(i);
               this.listapuertasentrada.remove(i);
               i=this.listapuertasentrada.size()+1;               
           }
       }
       return p;
   }
   
   public void agregarPuertaEntrada(Puerta p){
       this.listapuertasentrada.add(p);
       if(p.getTipoDePuerta().estadoPuerta().equalsIgnoreCase("entrada/salida")){
           this.listapuertasalida.add(p);
       }
   }
   
   public void agregarPuertaSalida(Puerta p){
       this.listapuertasalida.add(p);
       if(p.getTipoDePuerta().estadoPuerta().equalsIgnoreCase("entrada/salida")){
           this.listapuertasentrada.add(p);
       }
   }
    
    
   public void eliminarPuerta(String codigo) throws PuertaAsignadaException{
       if(this.puertaOcupada(codigo)){
           throw new PuertaAsignadaException();
       }
       this.listapuertas.remove(this.buscarPuerta(codigo));
   }
   
   /**
    * 
    * @param codigo
    * @return verdaero si la perta esta ocupada y falso si no esta ocupada
    */
   private boolean puertaOcupada(String codigo){
       boolean valor=false;
       List<Parqueadero> listap=new ArrayList<Parqueadero>(CampusSERVICIO.getInstancia().getCampus().getParqueaderos().values());
       for(Parqueadero p:listap){
           List<Puerta> listpuertas=p.getPuertas();
           for(Puerta pu:listpuertas){
               if(pu.getCodigo().equalsIgnoreCase(codigo)){
                   valor=true;
               }
           }
       }
        return valor;
       
   }
   
   public int buscarPuerta(String codigo,List<Puerta> lista){
       int valor=0;
       for(int i=0;i<lista.size();i++){
           if(lista.get(i).getCodigo().equalsIgnoreCase(codigo)){
               valor=i;
               i+=lista.size();
           }
       }
       return valor;
   }

   
   public int verCantidadPuertas(String codcampus) throws CodigodeCampusNoExisteException{
       return PuertasDAO.getInstancia().obtenerPuertas(codcampus).size();
   }
    /**
     * @return the puerta
     */
    public Puerta getPuerta() {
        return puerta;
    }

    /**
     * @param puerta the puerta to set
     */
    public void setPuerta(Puerta puerta) {
        this.puerta = puerta;
    }

    /**
     * @return the listapuertas
     */
    public List<Puerta> getListapuertas() {
        return listapuertas;
    }

    
    public void separarListas(){
        this.listaPuertasEntrada();
        this.listaPuertasSalida();
    }
    /**
     * @return the listapuertasentrada
     */
    public List<Puerta> getListapuertasentrada() {
        
        return listapuertasentrada;
    }

    /**
     * @return the listapuertasalida
     */
    public List<Puerta> getListapuertasalida() {
        
        return listapuertasalida;
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
}
