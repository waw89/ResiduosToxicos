/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package code;

import java.util.List;

/**
 * 
 */
public class Residuo {

    /**
     * Default constructor
     */
    public Residuo() {
    }

    /**
     * 
     */
    private long id;

    /**
     * 
     */
    private String codigo;

    /**
     * 
     */
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