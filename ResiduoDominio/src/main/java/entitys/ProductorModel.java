/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entitys;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 * Clase que representa la entidad Productor, Hereda de UsuarioModel
 *
 * @author PRIDE ANACONDA
 */
@Entity
@PrimaryKeyJoinColumn(name = "IdProductor")
@DiscriminatorValue("Productor")
@Table(name = "Productor")
public class ProductorModel extends UsuarioModel implements Serializable {

    /**
     * Lista de solicitudes que posee un productor
     */
    @OneToMany(mappedBy = "prod", cascade = CascadeType.ALL)
    private List<SolicitudTrasladoModel> listaSolicitudes;

    /**
     * Lista de residuos que ha producido un productor
     */
    @OneToMany(mappedBy = "prod", cascade = CascadeType.ALL)
    private List<ResiduoModel> listaResiduos;

    /**
     * Default constructor
     */
    public ProductorModel() {

    }

    /**
     * Metodo constructor con los parametros de la clase padre
     *
     * @param tipo
     * @param nombre
     * @param usuario
     * @param password
     */
    public ProductorModel(String tipo, String nombre, String usuario, String password) {
        super(tipo, nombre, usuario, password);

    }

    /**
     * Metodo constructor con los parametros de la clase padre y lista de
     * solicitudes
     *
     * @param solicitudes
     * @param tipo
     * @param nombre
     * @param usuario
     * @param password
     */
    public ProductorModel(List<SolicitudTrasladoModel> solicitudes, String tipo, String nombre, String usuario, String password) {
        super(tipo, nombre, usuario, password);
        this.listaSolicitudes = solicitudes;
    }

    /**
     * Metodo constructor con todos los parametros
     *
     * @param listaSolicitudes
     * @param listaResiduos
     * @param tipo
     * @param nombre
     * @param usuario
     * @param password
     */
    public ProductorModel(List<SolicitudTrasladoModel> listaSolicitudes, List<ResiduoModel> listaResiduos, String tipo, String nombre, String usuario, String password) {
        super(tipo, nombre, usuario, password);
        this.listaSolicitudes = listaSolicitudes;
        this.listaResiduos = listaResiduos;
    }

    /**
     * Metodo que agrega solicitud a la lista de solicitudes
     *
     * @param solicitud
     */
    public void agregaSolicitud(SolicitudTrasladoModel solicitud) {
        listaSolicitudes.add(solicitud);
    }

    /**
     * Metodo que obtiene la lista de solicitudes
     *
     * @return listaSolicitudes
     */
    public List<SolicitudTrasladoModel> getListaSolicitudes() {
        return listaSolicitudes;
    }

    /**
     * Metodo que establece la lista de solicitudes
     *
     * @param listaSolicitudes
     */
    public void setListaSolicitudes(List<SolicitudTrasladoModel> listaSolicitudes) {
        this.listaSolicitudes = listaSolicitudes;
    }

    /**
     * Metodo que obtiene la lista de residuos
     *
     * @return listaResiduos
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

}
