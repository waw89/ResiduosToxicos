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
 * Clase que representa la capa de negocio de un residuo
 *
 * @author PRIDE ANACONDA
 */
public class ResiduoNegocio {

    Util util = new Util();
    IResiduoDAO iResiduo = new ResiduoDAOImp();

    /**
     * Metodo que se encarga de guardar el residuo, recibiendo un DTO y
     * convirtiendolo a un ResiduoModel, tras eso se manda a persistencia
     *
     * @param dtoRegistraResiduo
     * @return residuoModel creado
     */
    public ResiduoModel guardar(DTORegistraResiduo dtoRegistraResiduo) {
        ResiduoModel res = util.convertirResiduoDTOAResiduo(dtoRegistraResiduo);

        iResiduo.crear(res);
        return res;
    }

    /**
     * Metodo que obtiene una lista de residuos, recuperandolos de persistencia
     *
     * @return Lista de residuos
     */
    public List<ResiduoModel> obtenerResiduos() {
        ArrayList<ResiduoModel> residuosList = new ArrayList<>();
        List<ResiduoModel> residuos = iResiduo.cargaResiduos(residuosList);
        return iResiduo.cargaResiduos(residuos);

    }

    /**
     * Metodo que busca los residuos por su nombre, recuperandolos de
     * persistencia
     *
     * @param nombre
     * @return residuoEncontrado
     */
    public ResiduoModel buscarResiduoPorNombre(String nombre) {
        ResiduoModel residuo = iResiduo.findResiduoNombre(nombre);

        return residuo;
    }

    /**
     * Metodo que valida si un residuo no existe en la base de datos,
     * consultando la capa de persistencia
     *
     * @param DTOresiduoARegistrar
     * @return true/false en caso de existir o no
     */
    public boolean validaResiduoNoExistente(DTORegistraResiduo DTOresiduoARegistrar) {
        ResiduoModel residuoARegistrar = util.convertirResiduoDTOAResiduo(DTOresiduoARegistrar);
        List<ResiduoModel> residuos = iResiduo.findResiduoModelEntities();

        boolean residuoNoExistente = true;

        for (ResiduoModel residuoActual : residuos) {
            // Verificar nulos
            if (residuoActual == null || residuoARegistrar == null) {
                // Manejo de error o lanzar una excepción según tu lógica de negocio
                return false;
            }

            // Verificar nombre y código del residuo principal
            String nombreResiduoRegistrado = residuoActual.getNombre();
            Long codigoResiduoRegistrado = residuoActual.getCodigo();

            if (nombreResiduoRegistrado.equalsIgnoreCase(residuoARegistrar.getNombre()) || codigoResiduoRegistrado.equals(residuoARegistrar.getCodigo())) {
                return false; // Si se encuentra una coincidencia en nombre o código, retorna false
            }

            // Descomentar esta sección si deseas verificar la existencia de químicos
            List<QuimicoModel> listaQuimicosResiduoRegistrado = residuoActual.getListaQuimicos();
            List<QuimicoModel> listaQuimicosResiduoARegistrar = residuoARegistrar.getListaQuimicos();

            if (listaQuimicosResiduoRegistrado.size() == listaQuimicosResiduoARegistrar.size()) {
                // Solo verifica si las listas tienen la misma longitud
                boolean mismaCombinacion = true;

                for (QuimicoModel quimicoActualResiduoARegistrar : listaQuimicosResiduoARegistrar) {
                    boolean quimicoEncontrado = false;

                    for (QuimicoModel quimicoActualResiduoRegistrado : listaQuimicosResiduoRegistrado) {
                        if (quimicoActualResiduoARegistrar.getNombre().equalsIgnoreCase(quimicoActualResiduoRegistrado.getNombre())) {
                            quimicoEncontrado = true;
                            break; // Si se encuentra un químico, no es necesario seguir buscando
                        }
                    }

                    if (!quimicoEncontrado) {
                        mismaCombinacion = false;
                        break; // Si un químico no se encuentra, la combinación no es la misma
                    }
                }

                if (mismaCombinacion) {
                    return false; // La combinación de químicos ya existe, retorna false
                }
            }

            if (!residuoNoExistente) {
                return false; // Si se encontró una coincidencia, termina la verificación y retorna false
            }
        }

        return residuoNoExistente; // Retorna el resultado final
    }

}
