/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Main;

import GUI.PantallaInicial;
import entitys.ProductorModel;





public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
  
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               
               ProductorModel p = new ProductorModel();
               p.setTipo("Productor");
               
               new PantallaInicial(p).setVisible(true);
               
               
          
               
               
            }
        });

    }
    
}
