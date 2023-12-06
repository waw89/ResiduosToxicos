/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.daos;

import entitys.TrasladoModel;
import java.util.List;

/**
 * Interfaz que define las operaciones para la manipulación de objetos
 * TrasladoModel. Proporciona métodos para crear, buscar y obtener información
 * sobre traslados, así como obtener listas de traslados y contar la cantidad
 * total de traslados.
 *
 * @author xfs85
 */
public interface ITrasladoDAO {

    /**
     * Crea un nuevo objeto TrasladoModel en la fuente de datos.
     *
     * @param trasladoModel Objeto TrasladoModel a ser creado.
     * @return Objeto TrasladoModel creado y almacenado en la fuente de datos.
     */
    public TrasladoModel create(TrasladoModel trasladoModel);

    /**
     * Obtiene una lista de todos los objetos TrasladoModel almacenados en la
     * fuente de datos.
     *
     * @return Lista de objetos TrasladoModel.
     */
    public List<TrasladoModel> findTrasladoModelEntities();

    /**
     * Obtiene una lista paginada de objetos TrasladoModel almacenados en la
     * fuente de datos.
     *
     * @param maxResults Número máximo de resultados por página.
     * @param firstResult Índice del primer resultado a recuperar.
     * @return Lista paginada de objetos TrasladoModel.
     */
    public List<TrasladoModel> findTrasladoModelEntities(int maxResults, int firstResult);

    /**
     * Busca y devuelve un objeto TrasladoModel basado en su identificador
     * único.
     *
     * @param id Identificador único del traslado a buscar.
     * @return Objeto TrasladoModel encontrado o null si no se encuentra.
     */
    public TrasladoModel findTrasladoModel(Long id);

    /**
     * Obtiene la cantidad total de objetos TrasladoModel almacenados en la
     * fuente de datos.
     *
     * @return Cantidad total de traslados.
     */
    public int getTrasladoModelCount();
}
