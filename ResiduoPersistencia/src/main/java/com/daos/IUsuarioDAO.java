/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.daos;

import entitys.UsuarioModel;
import java.util.List;

/**
 * Interfaz que define las operaciones para la manipulación de objetos
 * UsuarioModel. Proporciona métodos para crear, buscar, consultar credenciales
 * y obtener información sobre usuarios, así como obtener listas de usuarios y
 * contar la cantidad total de usuarios.
 *
 * @author xfs85
 */
public interface IUsuarioDAO {

    /**
     * Crea un nuevo objeto UsuarioModel en la fuente de datos.
     *
     * @param usuarioModel Objeto UsuarioModel a ser creado.
     * @return Objeto UsuarioModel creado y almacenado en la fuente de datos.
     */
    public UsuarioModel create(UsuarioModel usuarioModel);

    /**
     * Obtiene una lista de todos los objetos UsuarioModel almacenados en la
     * fuente de datos.
     *
     * @return Lista de objetos UsuarioModel.
     */
    public List<UsuarioModel> findUsuarioModelEntities();

    /**
     * Obtiene una lista paginada de objetos UsuarioModel almacenados en la
     * fuente de datos.
     *
     * @param maxResults Número máximo de resultados por página.
     * @param firstResult Índice del primer resultado a recuperar.
     * @return Lista paginada de objetos UsuarioModel.
     */
    public List<UsuarioModel> findUsuarioModelEntities(int maxResults, int firstResult);

    /**
     * Busca y devuelve un objeto UsuarioModel basado en su identificador único.
     *
     * @param id Identificador único del usuario a buscar.
     * @return Objeto UsuarioModel encontrado o null si no se encuentra.
     */
    public UsuarioModel findUsuarioModel(Long id);

    /**
     * Consulta las credenciales de un usuario basado en su nombre de usuario y
     * contraseña.
     *
     * @param nomUsuario Nombre de usuario del usuario.
     * @param contraseña Contraseña del usuario.
     * @return Objeto UsuarioModel si las credenciales son válidas, o null si no
     * coinciden.
     */
    public UsuarioModel consultaCredenciales(String nomUsuario, String contraseña);

    /**
     * Obtiene la cantidad total de objetos UsuarioModel almacenados en la
     * fuente de datos.
     *
     * @return Cantidad total de usuarios.
     */
    public int getUsuarioModelCount();

    /**
     * Llena una lista de objetos UsuarioModel con la información proporcionada.
     *
     * @param usuarios Lista de objetos UsuarioModel a ser llenada.
     * @return Lista de objetos UsuarioModel actualizada.
     */
    public List<UsuarioModel> llenaListaUsuarios(List<UsuarioModel> usuarios);
}
