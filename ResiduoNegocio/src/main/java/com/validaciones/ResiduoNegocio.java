/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.validaciones;

import com.daos.IResiduoDAO;
import com.daos.ResiduoDAOImp;
import com.dto.DTORegistraResiduo;
import com.utilerias.Util;
import entitys.QuimicoModel;
import entitys.ResiduoModel;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PRIDE ANACONDA
 */
public class ResiduoNegocio {

    Util util = new Util();
    IResiduoDAO iResiduo = new ResiduoDAOImp();

    public ResiduoModel guardar(DTORegistraResiduo dtoRegistraResiduo) {
        ResiduoModel res = util.convertirResiduoDTOAResiduo(dtoRegistraResiduo);

        iResiduo.crear(res);
        return res;
    }

    public List<ResiduoModel> obtenerResiduos() {
        ArrayList<ResiduoModel> residuosList = new ArrayList<>();
        List<ResiduoModel> residuos = iResiduo.cargaResiduos(residuosList);
        return iResiduo.cargaResiduos(residuos);

    }

    public ResiduoModel buscarResiduoPorNombre(String nombre) {
        ResiduoModel residuo = iResiduo.findResiduoNombre(nombre);

        return residuo;
    }

    public boolean validaResiduoNoExistente(DTORegistraResiduo DTOresiduoARegistrar) {

        ResiduoModel residuoARegistrar = util.convertirResiduoDTOAResiduo(DTOresiduoARegistrar);
        List<ResiduoModel> residuos = iResiduo.findResiduoModelEntities();

        for (ResiduoModel residuoActual : residuos) {
            String nombreResiduoRegistrado = residuoActual.getNombre();
            Long codigoResiduoRegistrado = residuoActual.getCodigo();

            if (nombreResiduoRegistrado.equalsIgnoreCase(residuoARegistrar.getNombre()) || codigoResiduoRegistrado == residuoARegistrar.getCodigo()) {
                return false;
            }

//            List<QuimicoModel> listaQuimicosResiduoRegistrado = residuoActual.getListaQuimicos();
//            List<QuimicoModel> listaQuimicosResiduoARegistrar = residuoARegistrar.getListaQuimicos();
//            for (QuimicoModel quimicoActualResiduoARegistrar : listaQuimicosResiduoARegistrar) {
//
//                for (QuimicoModel quimicoActualResiduoRegistrado : listaQuimicosResiduoRegistrado) {
//
//                    if (quimicoActualResiduoARegistrar.getNombre().equalsIgnoreCase(quimicoActualResiduoRegistrado.getNombre())) {
//                        return false;
//                    }
//                }
//
//            }
        }
        return true; 
        //return util.convertirResiduoADTORegistraResiduo(residuoARegistrar);

    }

}
