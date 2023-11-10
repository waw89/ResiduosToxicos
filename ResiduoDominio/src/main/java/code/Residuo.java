/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package code;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 
 */
@Entity
public class Residuo implements Serializable {

    /**
     * Default constructor
     */
    public Residuo() {
    }

    /**
     * 
     */
    @Id 
    @GeneratedValue(strategy =GenerationType.AUTO)
    private long id;

    /**
     * 
     */
    @Basic
    private String codigo;

    /**
     * 
     */
    @Basic
    private String nombre;

    /**
     * 
     */
    
    private List<Quimico> quimicos;

    public Residuo(long id, String codigo, String nombre, List<Quimico> quimicos) {
        this.id = id;
        this.codigo = codigo;
        this.nombre = nombre;
        this.quimicos = quimicos;
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
    
    public void agregaQuimico(Quimico quimico){
        quimicos.add(quimico); 
    }

    @Override
    public String toString() {
        return "Residuo{" + "id=" + id + ", codigo=" + codigo + ", nombre=" + nombre + ", quimicos=" + quimicos + '}';
    }
    
}