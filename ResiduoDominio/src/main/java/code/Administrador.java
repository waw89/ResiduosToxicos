/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package code;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 *
 * @author PRIDE ANACONDA
 */
@Entity
@PrimaryKeyJoinColumn (name = "IdAdministrador")
@DiscriminatorValue (value = "Administrador")
@Table (name = "Administrador")
public class Administrador extends Usuario  {

    public Administrador() {
    
    }
    
    public Administrador(String tipo, String nombre, String usuario, String password){
        super(tipo, nombre, usuario, password);
    }
    
     public Administrador(long id, String nombre,String usuario_correo, String passowrd_usuario) {
        super("Trasnsportista", nombre, usuario_correo, passowrd_usuario ); 
    }
     
     
}
