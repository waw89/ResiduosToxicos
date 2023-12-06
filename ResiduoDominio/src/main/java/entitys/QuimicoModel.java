/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entitys;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * Clase que representa la entidad Quimico
 *
 * @author PRIDE ANACONDA
 */
@Entity
@Table(name = "Quimico")
public class QuimicoModel implements Serializable {

    /**
     * Atributo ID del Quimico
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Metodo que obtiene el id del Quimico
     *
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * Metodo que establece el id del Quimico
     *
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Atributo nombre del quimico
     */
    @Basic
    @Column(name = "nombre")
    private String nombre;

    /**
     * Atributo lista de residuos que contienen quimicos
     */
    @ManyToMany(mappedBy = "listaQuimicos")
    private List<ResiduoModel> listaResiduos;

    /**
     * Default constructor
     */
    public QuimicoModel() {
    }

    /**
     * Metodo constructor con nombre del quimico
     *
     * @param nombre
     */
    public QuimicoModel(String nombre) {

        this.nombre = nombre;
    }

    /**
     * Metodo constructor con nombre y lista de residuos
     *
     * @param nombre
     * @param listaResiduos
     */
    public QuimicoModel(String nombre, List<ResiduoModel> listaResiduos) {
        this.nombre = nombre;
        this.listaResiduos = listaResiduos;
    }

    /**
     * Metodo que obtiene el nombre del quimico
     *
     * @return nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Metodo que establece el nombre del quimico
     *
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Metodo que obtiene la lista de residuos
     *
     * @return
     */
    public List<ResiduoModel> getListaResiduos() {
        return listaResiduos;
    }

    /**
     * Metodo que establece la lista de residuos
     *
     * @param listaResiduos
     */
    public void setListaResiduos(List<ResiduoModel> listaResiduos) {
        this.listaResiduos = listaResiduos;
    }

    /**
     * Metodo toString
     *
     * @return
     */
    @Override
    public String toString() {
        return this.nombre;
    }

}
