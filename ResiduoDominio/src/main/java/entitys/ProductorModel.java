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
 *
 * @author PRIDE ANACONDA
 */
@Entity
@PrimaryKeyJoinColumn (name = "IdProductor")
@DiscriminatorValue (value = "Productor")
@Table (name = "Productor")
public class ProductorModel extends UsuarioModel implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
    @OneToMany (mappedBy = "prod", cascade = CascadeType.ALL)
    private List<SolicitudTrasladoModel> listaSolicitudes;
    
    @OneToMany (mappedBy = "prod", cascade = CascadeType.ALL)
    private List<ResiduoModel> listaResiduos;
    /**
     * Default constructor
     */
    public ProductorModel() {
    
    }

    public ProductorModel(String tipo, String nombre, String usuario, String password) {
        super(tipo, nombre, usuario, password);
       
    }

    public ProductorModel(List<SolicitudTrasladoModel> solicitudes, String tipo, String nombre, String usuario, String password) {
        super(tipo, nombre, usuario, password);
        this.listaSolicitudes = solicitudes;
    }

    public ProductorModel(List<SolicitudTrasladoModel> listaSolicitudes, List<ResiduoModel> listaResiduos,String tipo, String nombre, String usuario, String password) {
        super(tipo, nombre, usuario, password);
        this.listaSolicitudes = listaSolicitudes;
        this.listaResiduos = listaResiduos;
    }
   
    public void agregaSolicitud(SolicitudTrasladoModel solicitud){
        listaSolicitudes.add(solicitud); 
    }

    public List<SolicitudTrasladoModel> getListaSolicitudes() {
        return listaSolicitudes;
    }

    public void setListaSolicitudes(List<SolicitudTrasladoModel> listaSolicitudes) {
        this.listaSolicitudes = listaSolicitudes;
    }

    public List<ResiduoModel> getListaResiduos() {
        return listaResiduos;
    }

    public void setListaResiduos(List<ResiduoModel> listaResiduos) {
        this.listaResiduos = listaResiduos;
    }
    
    
    
}
