/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package code;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 */
public class Vehiculo {

    /**
     * Default constructor
     */
    public Vehiculo() {
    }

    /**
     * 
     */
    private long id;
    
    /**
     * 
     */
    private String tipo;
    
    private String marca;
    
    private int modelo;
    
    private String linea;
    /**
     * 
     */
    private Transportista empresa;

    /**
     * 
     */
    private Traslado traslado;

    public Vehiculo(long id, String tipo, String marca, int modelo, String linea, Transportista empresa) {
        this.id = id;
        this.tipo = tipo;
        this.marca = marca;
        this.modelo = modelo;
        this.linea = linea;
        this.empresa = empresa;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getModelo() {
        return modelo;
    }

    public void setModelo(int modelo) {
        this.modelo = modelo;
    }

    public String getLinea() {
        return linea;
    }

    public void setLinea(String linea) {
        this.linea = linea;
    }

    public Transportista getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Transportista empresa) {
        this.empresa = empresa;
    }

    public Traslado getTraslado() {
        return traslado;
    }

    public void setTraslado(Traslado traslado) {
        this.traslado = traslado;
    }
    
    

    @Override
    public String toString() {
        return "Vehiculo{" + "id=" + id + ", tipo=" + tipo + ", marca=" + marca + ", modelo=" + modelo + ", linea=" + linea + '}';
    }
    
    
}