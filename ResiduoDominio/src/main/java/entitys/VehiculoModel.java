/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entitys;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

/**
 * Clase que representa la entidad Vehiculo
 *
 * @author PRIDE ANACONDA
 */
@Entity
public class VehiculoModel implements Serializable {

    /**
     * Id del vehiculo
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_vehiculo")
    private Long id;

    /**
     * Metodo que obtiene el id
     *
     * @return
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
     * Tipo de vehiculo
     */
    @Basic
    @Column(name = "Tipo")
    private String tipo;

    /**
     * Marca del vehiculo
     */
    @Basic
    @Column(name = "Marca")
    private String marca;

    /**
     * Modelo del vehiculo
     */
    @Basic
    @Column(name = "Modelo")
    private int modelo;

    /**
     * Linea del vehiculo
     */
    @Basic
    @Column(name = "Linea")
    private String linea;

    /**
     * Id del transportista
     */
    @ManyToOne
    @JoinColumn(name = "IdTransportista")
    private TransportistaModel trans;

    /**
     * Lista de vehiculos
     */
    @ManyToMany(mappedBy = "vehiculos")
    private List<TrasladoModel> traslado;

    /**
     * Default constructor
     */
    public VehiculoModel() {
    }

    /**
     * Metodo constructor con todos los atributos
     *
     * @param id
     * @param tipo
     * @param marca
     * @param modelo
     * @param linea
     * @param trans
     * @param traslado
     */
    public VehiculoModel(long id, String tipo, String marca, int modelo, String linea, TransportistaModel trans, List<TrasladoModel> traslado) {
        this.id = id;
        this.tipo = tipo;
        this.marca = marca;
        this.modelo = modelo;
        this.linea = linea;
        this.trans = trans;
        this.traslado = traslado;

    }

    /**
     * Metodo constructor con todos los atributos, excepto traslado
     *
     * @param id
     * @param tipo
     * @param marca
     * @param modelo
     * @param linea
     * @param trans
     */
    public VehiculoModel(Long id, String tipo, String marca, int modelo, String linea, TransportistaModel trans) {
        this.id = id;
        this.tipo = tipo;
        this.marca = marca;
        this.modelo = modelo;
        this.linea = linea;
        this.trans = trans;
    }

    /**
     * Metodo que obtiene el tipo
     *
     * @return tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Metodo que establece el tipo
     *
     * @param tipo
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * Metodo que obtiene la marca
     *
     * @return marca
     */
    public String getMarca() {
        return marca;
    }

    /**
     * Metodo que establece la marca
     *
     * @param marca
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     * Metodo que obtiene el modelo
     *
     * @return modelo
     */
    public int getModelo() {
        return modelo;
    }

    /**
     * Metodo que establece el modelo
     *
     * @param modelo
     */
    public void setModelo(int modelo) {
        this.modelo = modelo;
    }

    /**
     * Metodo que obtiene la linea del vehiculo
     *
     * @return
     */
    public String getLinea() {
        return linea;
    }

    /**
     * Metodo que establece la linea del vehiculo
     *
     * @param linea
     */
    public void setLinea(String linea) {
        this.linea = linea;
    }

    /**
     * Metodo que obtiene al transportista del vehiculo
     *
     * @return trans
     */
    public TransportistaModel getTrans() {
        return trans;
    }

    /**
     * Metodo que obtiene al transportista del vehiculo
     *
     * @param trans
     */
    public void setTrans(TransportistaModel trans) {
        this.trans = trans;
    }

    /**
     * Metodo que obtiene el traslado
     *
     * @return traslado
     */
    public List<TrasladoModel> getTraslado() {
        return traslado;
    }

    /**
     * Metodo que establece el traslado
     *
     * @param traslado
     */
    public void setTraslado(List<TrasladoModel> traslado) {
        this.traslado = traslado;
    }

}
