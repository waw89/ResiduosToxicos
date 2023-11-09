/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package code;


import java.util.*;

/**
 * 
 */
public class Ciudad {

    /**
     * Default constructor
     */
    public Ciudad() {
    }

    /**
     * 
     */
    private String nombre;

    /**
     * 
     */
    private List<Productor> productores = new ArrayList<>();

    public Ciudad(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public void agregaProductor(Productor productor){
        productores.add(productor); 
    }

    @Override
    public String toString() {
        return "Ciudad{" + "nombre=" + nombre + ", productores=" + productores + '}';
    }
    
}
