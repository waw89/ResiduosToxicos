/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Main;

import GUI.IniciarSesionFrm;
import GUI.PantallaInicial;

import GUI.RegistraResiduosFrm;
import code.Productor;
import com.validaciones.QuimicoNegocio;
import java.lang.Math; 
/**
 *
 * @author PC
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
  
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//               
//               Productor p = new Productor();
//               p.setTipo("Productor");
//               
//               new PantallaInicial(p).setVisible(true);
//               
//            }
//        });

        QuimicoNegocio quimNeg = new QuimicoNegocio(); 
        
        quimNeg.cargaQuimicos();
    }
    
}
