/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entitys;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

/**
 * Clase padre que representa la entidad Usuario
 *
 * @author PRIDE ANACONDA
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "Tipo")
@Table(name = "Usuario")
public class UsuarioModel implements Serializable {

    /**
     * id del usuario
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * tipo de usuario
     */
    @Basic
    @Column(name = "Tipo")
    private String tipo;

    /**
     * nombre del usuario
     */
    @Basic
    @Column(name = "Nombre")
    private String nombre;

    /**
     * nombre de usuario (con el que inicia sesión)
     */
    @Basic
    @Column(name = "nomUsuario")
    private String usuario;

    /**
     * contraseña del usuario
     */
    @Basic
    @Column(name = "Contraseña")
    private String password;

    /**
     * Metodo constructor por omision
     */
    public UsuarioModel() {
    }

    /**
     * Metodo constructor con todos los atributos
     *
     * @param tipo
     * @param nombre
     * @param usuario
     * @param password
     */
    public UsuarioModel(String tipo, String nombre, String usuario, String password) {
        this.tipo = tipo;
        this.nombre = nombre;
        this.usuario = usuario;
        this.password = password;
    }

    /**
     * Metodo que obtiene el id
     *
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * Metodo que establece el id
     *
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Metodo que obtiene el tipo de usuario
     *
     * @return
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Metodo que establece el tipo de usuario
     *
     * @param tipo
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * Metodo que obtiene el nombre del usuario
     *
     * @return
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Metodo que establece el nombre del usuario
     *
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Metodo que obtiene el username
     *
     * @return usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * Metodo que obtiene el username
     *
     * @param usuario
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * Metodo que obtiene la contraseña
     *
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Metodo que establece la constraseña
     *
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Metodo toString
     *
     * @return
     */
    @Override
    public String toString() {
        return "Usuario{" + "tipo=" + tipo + ", nombre=" + nombre + ", usuario=" + usuario + ", password=" + password + '}';
    }
}
