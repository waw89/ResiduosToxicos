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
import java.util.List;

/**
 * Clase que corresponde a la capa de negocio de un Quimico
 *
 * @author PRIDE ANACONDA
 */
public class QuimicoNegocio {

    IQuimicoDAO iQuimicoDAO = new QuimicoDAOImp();
    Util util = new Util();

    /**
     * Metodo que se encarga de llenar una lista de quimicos recuperandolos de
     * la capa de persistencia
     *
     * @return lista de quimicos
     */
    public List<QuimicoModel> llenaListaQuimicos() {

        ArrayList<QuimicoModel> quimicos = util.creaQuimicos();

        return iQuimicoDAO.llenaListaQuimicos(quimicos);

    }

    /**
     * Metodo que se encarga de buscar quimicos por su nombre, recuperandolo de
     * la capa de persistencia
     *
     * @param nombre
     * @return quimico encontrado
     */
    public QuimicoModel buscarQuimicoPorNombre(String nombre) {
        QuimicoModel quimico = iQuimicoDAO.findQuimicoNombre(nombre);

        return quimico;

    }
}
