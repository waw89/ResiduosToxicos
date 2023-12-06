/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.daos;

import entitys.QuimicoModel;
import java.util.List;

/**
 * Interfaz que define las operaciones para la manipulación de objetos
 * QuimicoModel.
 *
 * @author PRIDE ANACONDA
 */
public interface IQuimicoDAO {

    /**
     * Metodo que crea un objeto QuimicoModel en la base de datos
     * @param quimico 
     */
    public void create(QuimicoModel quimico);
    
    /**
     * Metodo que verifica si la lista de quimicos está vacía
     * @return true/false
     */
    public boolean verificaQuimicos();
    
    /**
     * Llena una lista de objetos QuimicoModel con la información proporcionada.
     *
     * @param quimicos Lista de objetos QuimicoModel a ser llenada.
     * @return Lista de objetos QuimicoModel actualizada.
     */
    public List<QuimicoModel> llenaListaQuimicos(List<QuimicoModel> quimicos);

    /**
     * Busca y devuelve un objeto QuimicoModel basado en su identificador único.
     *
     * @param id Identificador único del químico a buscar.
     * @return Objeto QuimicoModel encontrado o null si no se encuentra.
     */
    public QuimicoModel findQuimico(long id);

    /**
     * Busca y devuelve un objeto QuimicoModel basado en su nombre.
     *
     * @param nombre Nombre del químico a buscar.
     * @return Objeto QuimicoModel encontrado o null si no se encuentra.
     */
    public QuimicoModel findQuimicoNombre(String nombre);
    
     /**
     * Metodo que busca todos los registros de quimicos en la base de datos
     *
     * @return lista de quimicos encontrados
     */
    public List<QuimicoModel> findQuimicoEntities();
    
     /**
     * Metodo que busca todos los registros de quimicos en la base de datos
     * @param maxResults
     * @param firstResult
     * @return lista de quimicos encontrados
     */
    public List<QuimicoModel> findQuimicoEntities(int maxResults, int firstResult);
    
    /**
     * Metodo que busca todos los registros de quimicos en la base de datos
     * @param all
     * @param maxResults
     * @param firstResult
     * @return lista de quimicos encontrados
     */
    public List<QuimicoModel> findQuimicoEntities(boolean all, int maxResults, int firstResult);
    
    
}
