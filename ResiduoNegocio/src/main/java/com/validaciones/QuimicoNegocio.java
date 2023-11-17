/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.validaciones;

import com.daos.IQuimicoDAO;
import com.daos.QuimicoDAOImp;

import com.utilerias.Util;
import entitys.QuimicoModel;
import java.util.ArrayList;

/**
 *
 * @author PRIDE ANACONDA
 */
public class QuimicoNegocio {

    IQuimicoDAO iQuimicoDAO = new QuimicoDAOImp();
    Util util = new Util();

    public void cargaQuimicos() {

        ArrayList<QuimicoModel> quimicos = util.creaQuimicos();

        iQuimicoDAO.cargaQuimicos(quimicos);

        
        
    }
}
