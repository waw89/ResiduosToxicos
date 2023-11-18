/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.daos;

import entitys.QuimicoModel;
import java.util.List;

/**
 *
 * @author PRIDE ANACONDA
 */
public interface IQuimicoDAO {
    public List<QuimicoModel> cargaQuimicos(List<QuimicoModel> quimicos);
    public QuimicoModel findQuimico(long id);
    public QuimicoModel findQuimicoNombre(String nombre);
}
