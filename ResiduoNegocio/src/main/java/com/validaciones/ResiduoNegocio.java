/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.validaciones;

import code.Residuo;
import com.dao.IResiduoDAO;
import com.dao.ResiduoDAOImp;

/**
 *
 * @author PRIDE ANACONDA
 */
public class ResiduoNegocio {
    IResiduoDAO iRes = new ResiduoDAOImp();
    public void guarda(Residuo res){
        iRes.guarda(res); 
    }
    
}