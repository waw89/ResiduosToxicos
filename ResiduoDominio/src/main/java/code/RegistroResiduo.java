/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package code;

/**
 * Registro Residuos nos permite tener un catalogo de los residuos que están registrados en la ciudad
 */
public class RegistroResiduo {

    /**
     * 
     */
    private long id;

    /**
     * 
     */
    private long idProductor;

    /**
     * 
     */
    private long idResiduo;

    /**
     * Default constructor
     */
    public RegistroResiduo() {
    }

    public RegistroResiduo(long id, long idProductor, long idResiduo) {
        this.id = id;
        this.idProductor = idProductor;
        this.idResiduo = idResiduo;
    }

    @Override
    public String toString() {
        return "RegistroResiduo{" + "id=" + id + ", idProductor=" + idProductor + ", idResiduo=" + idResiduo + '}';
    }
    
    
}
