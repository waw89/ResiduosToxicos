/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.daosimp;

import code.Residuo;
import java.util.List;


/**
 *
 * @author PRIDE ANACONDA
 */
public interface IResiduoDAO {
    
    public void create(Residuo res);    
    public Residuo buscarResiduoPorId(long id);
     public List<Residuo> obtenerResiduos();
    
}
