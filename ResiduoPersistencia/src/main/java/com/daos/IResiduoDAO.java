/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.daos;

import code.Residuo;
import java.util.List;


/**
 *
 * @author PRIDE ANACONDA
 */
public interface IResiduoDAO {
    
    public void guarda(Residuo res);    
    public Residuo buscarResiduoPorId(long id);
     public List<Residuo> obtenerResiduos();
    
}
