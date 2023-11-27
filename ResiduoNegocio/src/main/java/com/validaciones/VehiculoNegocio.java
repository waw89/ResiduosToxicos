/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.validaciones;

import com.daos.ITransportistaDAO;
import com.daos.IVehiculoDAO;
import com.daos.TransportistaDAOImp;
import com.daos.VehiculoDAOImp;
import com.utilerias.Util;
import entitys.TransportistaModel;
import entitys.VehiculoModel;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PRIDE ANACONDA
 */
public class VehiculoNegocio {

    
    ITransportistaDAO iTransportista = new TransportistaDAOImp();
    List<VehiculoModel> listaVehiculos;
    IVehiculoDAO iVehiculo = new VehiculoDAOImp();

    public void creaAutos() {
        if (this.iVehiculo.findVehiculoModelEntities().isEmpty()) {
            List<TransportistaModel> transportistas = iTransportista.findTransportistaModelEntities();

            for (TransportistaModel transportista : transportistas) {
                List<VehiculoModel> vehiculos = new ArrayList<>();
                VehiculoModel auto1 = new VehiculoModel();
                auto1.setLinea("Focus");
                auto1.setMarca("Ford");
                auto1.setModelo(2004);
                auto1.setTipo("Automóvil");

                VehiculoModel auto2 = new VehiculoModel();
                auto2.setLinea("Atos");
                auto2.setMarca("Hyundai");
                auto2.setModelo(1500);
                auto2.setTipo("Automóvil");

                VehiculoModel auto3 = new VehiculoModel();
                auto3.setLinea("Linea 12");
                auto3.setMarca("Mercedes");
                auto3.setModelo(2009);
                auto3.setTipo("Camión");

                VehiculoModel auto4 = new VehiculoModel();
                auto4.setLinea("Linea 9");
                auto4.setMarca("Mercedes");
                auto4.setModelo(2012);
                auto4.setTipo("Camión");

                vehiculos.add(auto1);
                vehiculos.add(auto2);
                vehiculos.add(auto3);
                vehiculos.add(auto4);

                for (VehiculoModel vehiculo : vehiculos) {
                    vehiculo.setTrans(transportista);
                    iVehiculo.create(vehiculo);
                }

            }

        }
    }

    public List<VehiculoModel> obtenerVehiculos(Long id) {
        return iVehiculo.obtenerVehiculosPorTransportista(id);
    }

    public void convertirVehiculos(List<Long> idVehiculos) {
        List<VehiculoModel> listaVehiculos = new ArrayList<>();
        for (Long idVehiculo : idVehiculos) {
            listaVehiculos.add(iVehiculo.findVehiculoModel(idVehiculo));
        }
        
        this.listaVehiculos = listaVehiculos;       
    }

    public List<VehiculoModel> getListaVehiculos() {
        return listaVehiculos;
    }
    
    

}
