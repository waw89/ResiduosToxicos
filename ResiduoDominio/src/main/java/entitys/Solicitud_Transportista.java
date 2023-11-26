/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entitys;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author xfs85
 */
@Entity
@Table(name = "Solicitud_Transportista")
public class Solicitud_Transportista implements Serializable {

    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_solicitud", referencedColumnName = "idSolicitud")
    private SolicitudTrasladoModel solicitud;
    
    @ManyToOne
    @JoinColumn(name = "id_transportista", referencedColumnName = "idTransportista")
    private ResiduoModel residuo;
     
     
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public SolicitudTrasladoModel getSolicitud() {
        return solicitud;
    }

    public void setSolicitud(SolicitudTrasladoModel solicitud) {
        this.solicitud = solicitud;
    }

    public ResiduoModel getResiduo() {
        return residuo;
    }

    public void setResiduo(ResiduoModel residuo) {
        this.residuo = residuo;
    }
    
    
    
}

 
