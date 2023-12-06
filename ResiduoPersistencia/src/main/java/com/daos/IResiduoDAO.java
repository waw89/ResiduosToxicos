/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.daos;

import entitys.ResiduoModel;
import java.util.List;

/**
 * Interfaz que define las operaciones para la manipulación de objetos
 * ResiduoModel Proporciona métodos para crear, cargar, y buscar residuos por su
 * identificador, nombre, y obtener una lista de todos los residuos.
 *
 * @author xfs85
 */
public interface IResiduoDAO {

    /**
     * Crea un nuevo objeto ResiduoModel en la fuente de datos.
     *
     * @param residuo Objeto ResiduoModel a ser creado.
     * @return Objeto ResiduoModel creado y almacenado en la fuente de datos.
     */
    public ResiduoModel crear(ResiduoModel residuo);

    /**
     * Carga una lista de objetos ResiduoModel con la información proporcionada.
     *
     * @param residuos Lista de objetos ResiduoModel a ser cargada.
     * @return Lista de objetos ResiduoModel actualizada.
     */
    public List<ResiduoModel> cargaResiduos(List<ResiduoModel> residuos);

    /**
     * Busca y devuelve un objeto ResiduoModel basado en su identificador único.
     *
     * @param id Identificador único del residuo a buscar.
     * @return Objeto ResiduoModel encontrado o null si no se encuentra.
     */
    public ResiduoModel findResiduoModel(long id);

    /**
     * Busca y devuelve un objeto ResiduoModel basado en su nombre.
     *
     * @param nombre Nombre del residuo a buscar.
     * @return Objeto ResiduoModel encontrado o null si no se encuentra.
     */
    public ResiduoModel findResiduoNombre(String nombre);

    /**
     * Obtiene una lista de todos los objetos ResiduoModel almacenados en la
     * fuente de datos.
     *
     * @return Lista de objetos ResiduoModel.
     */
    public List<ResiduoModel> findResiduoModelEntities();
}
