    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package code;


/**
 * Clase que nos permite obtener los quimicos que se encuentran asignados a cada residuo.
 */
public class EspecificacionQuimicos {

    /**
     * Default constructor
     */
    public EspecificacionQuimicos() {
    }
    
    /**
     * 
     */
    private long id;

    /**
     * 
     */
    private int idQuimico;

    /**
     * 
     */
    private long idResiduo;

    public EspecificacionQuimicos(long id, int idQuimico, long idResiduo) {
        this.id = id;
        this.idQuimico = idQuimico;
        this.idResiduo = idResiduo;
    }

    @Override
    public String toString() {
        return "EspecificacionQuimicos{" + "id=" + id + ", idQuimico=" + idQuimico + ", idResiduo=" + idResiduo + '}';
    }
    
    

}