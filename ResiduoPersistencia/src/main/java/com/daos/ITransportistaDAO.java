/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.daos;

import entitys.TransportistaModel;
import java.util.List;

/**
 * Interfaz que define las operaciones para la manipulación de objetos
 * TransportistaModel. Proporciona métodos para crear, buscar y cargar
 * transportistas, así como obtener listas de transportistas y contar la
 * cantidad total de transportistas.
 *
 * @author xfs85
 */
public interface ITransportistaDAO {

    /**
     * Crea un nuevo objeto TransportistaModel en la fuente de datos.
     *
     * @param transportistaModel Objeto TransportistaModel a ser creado.
     * @return Objeto TransportistaModel creado y almacenado en la fuente de
     * datos.
     */
    public TransportistaModel create(TransportistaModel transportistaModel);

    /**
     * Obtiene una lista de todos los objetos TransportistaModel almacenados en
     * la fuente de datos.
     *
     * @return Lista de objetos TransportistaModel.
     */
    public List<TransportistaModel> findTransportistaModelEntities();

    /**
     * Busca y devuelve un objeto TransportistaModel basado en su identificador
     * único.
     *
     * @param id Identificador único del transportista a buscar.
     * @return Objeto TransportistaModel encontrado o null si no se encuentra.
     */
    public TransportistaModel findTransportistaModel(Long id);

    /**
     * Obtiene la cantidad total de objetos TransportistaModel almacenados en la
     * fuente de datos.
     *
     * @return Cantidad total de transportistas.
     */
    public int getTransportistaModelCount();

    /**
     * Carga una lista de objetos TransportistaModel con la información
     * proporcionada.
     *
     * @param transportistaList Lista de objetos TransportistaModel a ser
     * cargada.
     * @return Lista de objetos TransportistaModel actualizada.
     */
    public List<TransportistaModel> cargaTransportistas(List<TransportistaModel> transportistaList);
}
