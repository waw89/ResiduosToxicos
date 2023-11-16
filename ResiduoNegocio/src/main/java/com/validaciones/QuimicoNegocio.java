/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.validaciones;

import code.Quimico;
import com.daos.IQuimicoDAO;
import com.daos.QuimicoDAOImp;
import com.daos.QuimicoJpaController;
import com.utilerias.Util;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PRIDE ANACONDA
 */
public class QuimicoNegocio {
    
    IQuimicoDAO iQuimicoDAO = new QuimicoDAOImp(); 
    Util util = new Util();
    public boolean cargaQuimicos(){
           Quimico quim = new Quimico("Hola"); 
           Quimico quim2 = new Quimico("Hola"); 
           List<Quimico> quimicos = new ArrayList<>();
           quimicos.add(quim);
           quimicos.add(quim2);
           QuimicoJpaController qj = new QuimicoJpaController(); 
           qj.create(quimicos);
           return true;
    }
}
