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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Clase que representa la entidad residuo
 *
 * @author PRIDE ANACONDA
 */
@Entity
@Table(name = "Residuo")
public class ResiduoModel implements Serializable {

    /**
     * Id del residuo
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_residuo")
    private Long id;

    /**
     * Metodo que obtiene el id del residuo
     *
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * Metodo que establece el id del residuo
     *
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Codigo del residuo
     */
    @Basic
    @Column(name = "codigo")
    private Long codigo;

    /**
     * Nombre del residuo
     */
    @Basic
    @Column(name = "nombre")
    private String nombre;

    /**
     * Objeto tipo productor que produjo el residuo
     */
    @ManyToOne
    @JoinColumn(name = "IdProductor")
    private ProductorModel prod;

    /**
     * Lista de quimicos que conforman el residuo Creación de tabla asociación
     * "Residuo_Quimico"
     */
    @ManyToMany
    @JoinTable(
            name = "Residuo_Quimico",
            joinColumns = @JoinColumn(name = "id_Residuo"),
            inverseJoinColumns = @JoinColumn(name = "id_Quimico")
    )
    private List<QuimicoModel> listaQuimicos;

    /**
     * Lista de solicitudes de traslados que poseen ese residuo
     */
    @ManyToMany(mappedBy = "listaResiduos")
    private List<SolicitudTrasladoModel> listaSolTraslados;

    /**
     * Default constructor
     */
    public ResiduoModel() {
    }

    /**
     * Metodo constructor con 3 parametros
     *
     * @param codigo
     * @param nombre
     * @param productor
     */
    public ResiduoModel(long codigo, String nombre, ProductorModel productor) {

        this.codigo = codigo;
        this.nombre = nombre;
        this.prod = productor;

    }

    /**
     * Metodo que obtiene el codigo del residuo
     *
     * @return codigo
     */
    public long getCodigo() {
        return codigo;
    }

    /**
     * Metodo que establece el codigo del residuo
     *
     * @param codigo
     */
    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    /**
     * Metodo que obtiene el nombre del residuo
     *
     * @return nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Metodo que obtiene el nombre del residuo
     *
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Metodo que obtiene el productor
     *
     * @return prod
     */
    public ProductorModel getProductor() {
        return prod;
    }

    /**
     * Metodo que establece el productor
     *
     * @param prod
     */
    public void setProductor(ProductorModel prod) {
        this.prod = prod;
    }

    /**
     * Metodo que obtiene la lista de quimicos
     *
     * @return listaQuimicos
     */
    public List<QuimicoModel> getListaQuimicos() {
        return listaQuimicos;
    }

    /**
     * Metodo que establece la lista de quimicos
     *
     * @param listaQuimicos
     */
    public void setListaQuimicos(List<QuimicoModel> listaQuimicos) {
        this.listaQuimicos = listaQuimicos;
    }

    /**
     * Metodo que obtiene la lista de solicitudes
     *
     * @return listaSolTraslados
     */
    public List<SolicitudTrasladoModel> getListaSolTraslados() {
        return listaSolTraslados;
    }

    /**
     * Metodo que establece la solicitud de traslados
     *
     * @param listaSolTraslados
     */
    public void setListaSolTraslados(List<SolicitudTrasladoModel> listaSolTraslados) {
        this.listaSolTraslados = listaSolTraslados;
    }

    /**
     * Metodo toString
     *
     * @return
     */
    @Override
    public String toString() {
        return "ResiduoModel{" + "id=" + id + ", codigo=" + codigo + ", nombre=" + nombre + '}';
    }

}
