/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.daos;

import entitys.ProductorModel;
import java.util.List;

/**
 * Interfaz para la clase DAO de Productor
 *
 * @author xfs85
 */
public interface IProductorDAO {

    /**
     * Metodo que crea registros en la tabla prodcutor
     *
     * @param productorModel
     * @return productorModel
     */
    public ProductorModel create(ProductorModel productorModel);

    /**
     * Metodo que busca todos los registros de la tabla productor en la base de
     * datos
     *
     * @return lista de productores
     */
    public List<ProductorModel> findProductorModelEntities();

    /**
     * Metodo que busca todos los registros de la tabla productor en la base de
     * datos
     *
     * @param maxResults
     * @param firstResult
     * @return lista de productores
     */
    public List<ProductorModel> findProductorModelEntities(int maxResults, int firstResult);

    /**
     * Metodo que busca en los registros de la tabla productor en la base de
     * datos en base a su id
     *
     * @param id
     * @return productor encontrado
     */
    public ProductorModel findProductorModel(Long id);

    /**
     * Obtiene el numero de registros de la tabla productor
     *
     * @return numero de registros
     */
    public int getProductorModelCount();

}
