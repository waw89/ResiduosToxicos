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
 * Clase que representa la entidad AdministradorModel, Hereda de UsuarioModel
 *
 * @author PRIDE ANACONDA
 */
@Entity
@PrimaryKeyJoinColumn(name = "IdAdministrador")
@DiscriminatorValue("Administrador")
@Table(name = "Administrador")
public class AdministradorModel extends UsuarioModel implements Serializable {

    /**
     * Constructor por omisión
     */
    public AdministradorModel() {

    }

    /**
     * Constructor que recibe todos los parametros, excepto el ID
     *
     * @param tipo
     * @param nombre
     * @param usuario
     * @param password
     */
    public AdministradorModel(String tipo, String nombre, String usuario, String password) {
        super(tipo, nombre, usuario, password);
    }

    /**
     * Constructor que recibe todos los parametros
     *
     * @param id
     * @param nombre
     * @param usuario_correo
     * @param password
     */
    public AdministradorModel(long id, String nombre, String usuario_correo, String password) {
        super("Administrador", nombre, usuario_correo, password);
    }

}
