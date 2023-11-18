/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.daos;

import entitys.UsuarioModel;
import java.util.List;

/**
 *
 * @author xfs85
 */
interface IUsuarioDAO {
    public UsuarioModel create(UsuarioModel usuarioModel);
    public List<UsuarioModel> findUsuarioModelEntities();
    public List<UsuarioModel> findUsuarioModelEntities(int maxResults, int firstResult);
    public UsuarioModel findUsuarioModel(Long id);
    public int getUsuarioModelCount();
    
}
