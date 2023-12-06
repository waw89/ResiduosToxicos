/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.daos;

import entitys.VehiculoModel;
import java.util.List;

/**
 * Interfaz que define las operaciones para la manipulación de objetos
 * VehiculoModel. Proporciona métodos para crear, buscar y obtener información
 * sobre vehículos, así como obtener listas de vehículos y contar la cantidad
 * total de vehículos.
 *
 * @author xfs85
 */
public interface IVehiculoDAO {

    /**
     * Crea un nuevo objeto VehiculoModel en la fuente de datos.
     *
     * @param vehiculoModel Objeto VehiculoModel a ser creado.
     * @return Objeto VehiculoModel creado y almacenado en la fuente de datos.
     */
    public VehiculoModel create(VehiculoModel vehiculoModel);

    /**
     * Obtiene una lista de todos los objetos VehiculoModel almacenados en la
     * fuente de datos.
     *
     * @return Lista de objetos VehiculoModel.
     */
    public List<VehiculoModel> findVehiculoModelEntities();

    /**
     * Obtiene una lista paginada de objetos VehiculoModel almacenados en la
     * fuente de datos.
     *
     * @param maxResults Número máximo de resultados por página.
     * @param firstResult Índice del primer resultado a recuperar.
     * @return Lista paginada de objetos VehiculoModel.
     */
    public List<VehiculoModel> findVehiculoModelEntities(int maxResults, int firstResult);

    /**
     * Busca y devuelve un objeto VehiculoModel basado en su identificador
     * único.
     *
     * @param id Identificador único del vehículo a buscar.
     * @return Objeto VehiculoModel encontrado o null si no se encuentra.
     */
    public VehiculoModel findVehiculoModel(Long id);

    /**
     * Obtiene la cantidad total de objetos VehiculoModel almacenados en la
     * fuente de datos.
     *
     * @return Cantidad total de vehículos.
     */
    public int getVehiculoModelCount();

    /**
     * Obtiene una lista de vehículos asociados a un transportista específico.
     *
     * @param idTransportista Identificador único del transportista.
     * @return Lista de objetos VehiculoModel asociados al transportista.
     */
    public List<VehiculoModel> obtenerVehiculosPorTransportista(Long idTransportista);
}
