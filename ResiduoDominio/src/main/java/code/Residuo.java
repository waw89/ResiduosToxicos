/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package code;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 
 */
@Entity
@Table(name="Residuo")
public class Residuo implements Serializable {
    /**
     * 
     */
    @Id 
    @GeneratedValue(strategy =GenerationType.AUTO)
    @Column (name = "Id_Residuo")
    private long id;

    /**
     * 
     */
    @Basic
    @Column(name="codigo")
    private String codigo;

    /**
     * 
     */
    @Basic
    @Column(name="nombre")
    private String nombre;


    
    /**
     * Default constructor
     */
    public Residuo() {
    }

    public Residuo(String codigo, String nombre) {

        this.codigo = codigo;
        this.nombre = nombre;
    
    }
    
    
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    


    @Override
    public String toString() {
        return "Residuo{" + "id=" + id + ", codigo=" + codigo + ", nombre=" + nombre +'}';
    }
    
}