/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package code;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * 
 */
@Entity
@Table (name = "Vehiculo")
public class Vehiculo  {

    /**
     * 
     */
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    @Column (name = "Id_Vehiculo")
    private long id;
    
    /**
     * 
     */
    @Basic
    @Column (name = "Tipo")
    private String tipo;
    
    @Basic
    @Column (name = "Marca")
    private String marca;
    
    @Basic
    @Column (name = "Modelo")
    private int modelo;
    
    @Basic
    @Column (name = "Linea")
    private String linea;
    /**
     * 
     */
    @ManyToOne
    @JoinColumn (name = "IdTransportista")
    private Transportista trans;


    
    /**
     * Default constructor
     */
    public Vehiculo() {
    }

    public Vehiculo(long id, String tipo, String marca, int modelo, String linea, Transportista trans) {
        this.id = id;
        this.tipo = tipo;
        this.marca = marca;
        this.modelo = modelo;
        this.linea = linea;
        this.trans = trans;
    
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

    public Transportista getTrans() {
        return trans;
    }

    public void setTrans(Transportista trans) {
        this.trans = trans;
    }



}