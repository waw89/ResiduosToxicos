/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entitys;

import java.io.Serializable;
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
@DiscriminatorValue ("Administrador")
@Table (name = "Administrador")
public class AdministradorModel extends UsuarioModel implements Serializable {


    public AdministradorModel() {
    
    }
    
    public AdministradorModel(String tipo, String nombre, String usuario, String password){
        super(tipo, nombre, usuario, password);
    }
    
     public AdministradorModel(long id, String nombre,String usuario_correo, String password) {
        super("Administrador", nombre, usuario_correo, password); 
    }
     
    
}
