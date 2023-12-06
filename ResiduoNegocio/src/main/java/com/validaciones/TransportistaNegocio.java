package com.validaciones;

import entitys.TransportistaModel;
import com.daos.ITransportistaDAO;
import com.daos.TransportistaDAOImp;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa la capa de negocio para la entidad transportista
 *
 * @author PRIDE ANACONDA
 */
public class TransportistaNegocio {

    ITransportistaDAO transportistaDAO = new TransportistaDAOImp();

    /**
     * Método obtenerTransportistas que invoca al método de cargaTransportistas
     * de la capa de persistencia para regresar la lista de empresas
     * transportistas
     *
     * @return la lista de empresas transportistas
     */
    public List<TransportistaModel> obtenerTransportistas() {

        ArrayList<TransportistaModel> transportistasList = new ArrayList<>();
        List<TransportistaModel> transportistas = transportistaDAO.cargaTransportistas(transportistasList);

        return transportistas;
    }
}
