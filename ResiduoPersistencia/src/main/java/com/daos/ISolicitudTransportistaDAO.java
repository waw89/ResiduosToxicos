/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.daos;

import com.daos.exceptions.NonexistentEntityException;
import entitys.Solicitud_Transportista;
import java.util.List;

/**
 *
 * @author xfs85
 */
public interface ISolicitudTransportistaDAO {
    
    /**
     * Crea y persiste una nueva solicitud de transportista en la base de datos.
     *
     * @param solicitud_Transportista Objeto Solicitud_Transportista a ser
     * creado y persistido.
     */
    public void create(Solicitud_Transportista solicitud_Transportista);
    /**
     * Edita y actualiza la información de una solicitud de transportista en la
     * base de datos.
     *
     * @param solicitud_Transportista Objeto Solicitud_Transportista a ser
     * actualizado.
     * @throws NonexistentEntityException Si la entidad no existe en la base de
     * datos.
     * @throws Exception Si ocurre un error durante la actualización.
     */
    public void edit(Solicitud_Transportista solicitud_Transportista) throws NonexistentEntityException, Exception;
    
    
    /**
     * Elimina una solicitud de transportista de la base de datos.
     *
     * @param id Identificador único de la solicitud de transportista a ser
     * eliminada.
     * @throws NonexistentEntityException Si la entidad no existe en la base de
     * datos.
     */
    public void destroy(Long id) throws NonexistentEntityException;
    
     /**
     * Obtiene una lista de todas las solicitudes de transportista almacenadas
     * en la base de datos.
     *
     * @return Lista de objetos Solicitud_Transportista.
     */
    public List<Solicitud_Transportista> findSolicitud_TransportistaEntities();
    
     /**
     * Obtiene una lista paginada de solicitudes de transportista almacenadas en
     * la base de datos.
     *
     * @param maxResults Número máximo de resultados por página.
     * @param firstResult Índice del primer resultado a recuperar.
     * @return Lista paginada de objetos Solicitud_Transportista.
     */
    public List<Solicitud_Transportista> findSolicitud_TransportistaEntities(int maxResults, int firstResult);
    
    /**
     * Busca y devuelve una solicitud de transportista basada en su
     * identificador único.
     *
     * @param id Identificador único de la solicitud de transportista a buscar.
     * @return Objeto Solicitud_Transportista encontrado o null si no se
     * encuentra.
     */
    public Solicitud_Transportista findSolicitud_Transportista(Long id);
    
     /**
     * Obtiene la cantidad total de solicitudes de transportista almacenadas en
     * la base de datos.
     *
     * @return Cantidad total de solicitudes de transportista.
     */
    public int getSolicitud_TransportistaCount();
    
    
}
