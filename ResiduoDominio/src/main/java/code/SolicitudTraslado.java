/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package code;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 */
public class SolicitudTraslado {

    /**
     *
     */
    private long id;

    /**
     *
     */
    private Date fecha;

    /**
     *
     */
    private float cantidadRes;

    /**
     *
     */
    private boolean asignado;

    /**
     *
     */
    private Residuo residuo;

    /**
     *
     */
    private List<Transportista> transportistas = new ArrayList<>();

    /**
     *
     */
    private Productor productor;

    /**
     * Default constructor
     */
    public SolicitudTraslado() {
    }

    public SolicitudTraslado(long id, Date fecha, float cantidadRes, boolean asignado, Residuo residuo, Productor productor) {
        this.id = id;
        this.fecha = fecha;
        this.cantidadRes = cantidadRes;
        this.asignado = asignado;
        this.residuo = residuo;
        this.productor = productor;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public float getCantidadRes() {
        return cantidadRes;
    }

    public void setCantidadRes(float cantidadRes) {
        this.cantidadRes = cantidadRes;
    }

    public boolean esAsignado() {
        return asignado;
    }

    public void setAsignado(boolean asignado) {
        this.asignado = asignado;
    }

    public Residuo getResiduo() {
        return residuo;
    }

    public void setResiduo(Residuo residuo) {
        this.residuo = residuo;
    }

    public List<Transportista> getTransportistas() {
        return transportistas;
    }

    public void setTransportistas(List<Transportista> transportistas) {
        this.transportistas = transportistas;
    }

    public Productor getProductor() {
        return productor;
    }

    public void setProductor(Productor productor) {
        this.productor = productor;
    }
    
    public void agregaTransportista(Transportista transportista){
        transportistas.add(transportista); 
    }
    
    @Override
    public String toString() {
        return "SolicitudTraslado{" + "id=" + id + ", fecha=" + fecha + ", cantidadRes=" + cantidadRes + ", asignado=" + asignado + ", residuo=" + residuo + ", transportistas=" + transportistas + ", productor=" + productor + '}';
    }
    
    
}
