/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dao;

import code.Residuo;
import com.mysql.ResiduoJpaController;

/**
 *
 * @author PRIDE ANACONDA
 */
public class ResiduoDAOImp implements IResiduoDAO {

    public void guarda(Residuo res) {
        ResiduoJpaController resJPA = new ResiduoJpaController();

        resJPA.create(res);

    }
}
