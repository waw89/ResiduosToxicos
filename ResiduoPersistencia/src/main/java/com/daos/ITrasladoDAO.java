/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.daos;

import entitys.TrasladoModel;
import java.util.List;

/**
 *
 * @author xfs85
 */
public interface ITrasladoDAO {

    public TrasladoModel create(TrasladoModel trasladoModel);

    public List<TrasladoModel> findTrasladoModelEntities();

    public List<TrasladoModel> findTrasladoModelEntities(int maxResults, int firstResult);

    public TrasladoModel findTrasladoModel(Long id);

    public int getTrasladoModelCount();

}
