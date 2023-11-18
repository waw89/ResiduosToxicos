/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entitys;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author PRIDE ANACONDA
 */
@Entity
public class VehiculoModel implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
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
    private TransportistaModel trans;


    
    /**
     * Default constructor
     */
    public VehiculoModel() {
    }

    public VehiculoModel(long id, String tipo, String marca, int modelo, String linea, TransportistaModel trans) {
        this.id = id;
        this.tipo = tipo;
        this.marca = marca;
        this.modelo = modelo;
        this.linea = linea;
        this.trans = trans;
    
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

    public TransportistaModel getTrans() {
        return trans;
    }

    public void setTrans(TransportistaModel trans) {
        this.trans = trans;
    }


    
}
