/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package code;


/**
 * 
 */
public class Quimico {



    /**
     * 
     */
    private long id;

    /**
     * 
     */
    private String nombre;
    
    /**
     * Default constructor
     */
    public Quimico() {
        
    }
    public Quimico(long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Quimico{" + "id=" + id + ", nombre=" + nombre + '}';
    }
        
}