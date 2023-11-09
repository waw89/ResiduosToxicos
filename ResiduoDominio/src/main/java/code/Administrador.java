/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package code;

/**
 *
 * @author PRIDE ANACONDA
 */
public class Administrador extends Usuario {
    private String nombre;
    private long id; 
    public Administrador() {
    }
    
     public Administrador(long id, String nombre,String usuario_correo, String passowrd_usuario) {
        super("Trasnsportista", nombre, usuario_correo, passowrd_usuario ); 
    }
     
     
}
