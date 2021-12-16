/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SERVICIO;

import DATO.UsuarioNoExisteException;
import DATO.VehiculoDAO;
import java.io.IOException;
import org.josql.QueryExecutionException;
import org.josql.QueryParseException;

/**
 *
 * @author pc_hp
 */
public class VehiculoSERVICIO {

    public boolean eliminarVehiculo(Long id) throws UsuarioNoExisteException, QueryParseException, QueryExecutionException, IOException {
        return VehiculoDAO.getInstancia().eliminar(id);
    }

}
