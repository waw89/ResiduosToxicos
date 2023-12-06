/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.daos;

import entitys.SolicitudTrasladoModel;
import java.util.List;

/**
 * Interfaz que define las operaciones para la manipulación de objetos
 * SolicitudTrasladoModel. Proporciona métodos para crear, actualizar, buscar y
 * cargar solicitudes de traslado, así como obtener listas de solicitudes y
 * contar la cantidad total de solicitudes.
 *
 * @author xfs85
 */
public interface ISolicitudTrasladoDAO {

    /**
     * Crea un nuevo objeto SolicitudTrasladoModel en la fuente de datos.
     *
     * @param solicitudTrasladoModel Objeto SolicitudTrasladoModel a ser creado.
     * @return Objeto SolicitudTrasladoModel creado y almacenado en la fuente de
     * datos.
     */
    public SolicitudTrasladoModel create(SolicitudTrasladoModel solicitudTrasladoModel);

    /**
     * Actualiza un objeto SolicitudTrasladoModel en la fuente de datos.
     *
     * @param solicitudTrasladoModel Objeto SolicitudTrasladoModel a ser
     * actualizado.
     * @return Objeto SolicitudTrasladoModel actualizado en la fuente de datos.
     */
    public SolicitudTrasladoModel update(SolicitudTrasladoModel solicitudTrasladoModel);

    /**
     * Obtiene una lista de todos los objetos SolicitudTrasladoModel almacenados
     * en la fuente de datos.
     *
     * @return Lista de objetos SolicitudTrasladoModel.
     */
    public List<SolicitudTrasladoModel> findSolicitudTrasladoModelEntities();

    /**
     * Obtiene una lista paginada de objetos SolicitudTrasladoModel almacenados
     * en la fuente de datos.
     *
     * @param maxResults Número máximo de resultados por página.
     * @param firstResult Índice del primer resultado a recuperar.
     * @return Lista paginada de objetos SolicitudTrasladoModel.
     */
    public List<SolicitudTrasladoModel> findSolicitudTrasladoModelEntities(int maxResults, int firstResult);

    /**
     * Busca y devuelve un objeto SolicitudTrasladoModel basado en su
     * identificador único.
     *
     * @param id Identificador único de la solicitud de traslado a buscar.
     * @return Objeto SolicitudTrasladoModel encontrado o null si no se
     * encuentra.
     */
    public SolicitudTrasladoModel findSolicitudTrasladoModel(Long id);

    /**
     * Obtiene la cantidad total de objetos SolicitudTrasladoModel almacenados
     * en la fuente de datos.
     *
     * @return Cantidad total de solicitudes de traslado.
     */
    public int getSolicitudTrasladoModelCount();

    /**
     * Carga una lista de objetos SolicitudTrasladoModel con la información
     * proporcionada.
     *
     * @param solicitudesList Lista de objetos SolicitudTrasladoModel a ser
     * cargada.
     * @return Lista de objetos SolicitudTrasladoModel actualizada.
     */
    public List<SolicitudTrasladoModel> cargaSolicitudes(List<SolicitudTrasladoModel> solicitudesList);
}
