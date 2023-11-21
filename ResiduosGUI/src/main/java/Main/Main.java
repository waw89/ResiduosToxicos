/*
 *
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Main;

import GUI.IniciarSesionFrm;
import GUI.PantallaInicial;
import com.dto.DTOIniciarSesion;
import com.utilerias.Util;
import com.validaciones.UsuarioNegocio;
import entitys.ProductorModel;
import entitys.UsuarioModel;
import java.util.ArrayList;
import java.util.List;





public class Main {
Util u = new Util();

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
     
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               
               
               
               new IniciarSesionFrm().setVisible(true);
               
      
            }
        });

    }
    
  
}
    
    
