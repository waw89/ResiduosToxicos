
package code;


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
 * 
 */
@Entity
@Table (name="Quimico")
public class Quimico implements Serializable  {

    /**
     * 
     */
    @Id
    @GeneratedValue (strategy =GenerationType.IDENTITY)
    private long id;

    /**
     * 
     */
    @Basic
    @Column(name="nombre")
    private String nombre;
    
    
    @ManyToMany (mappedBy = "listaQuimicos")
    private List<Residuo> listaResiduos;
    
    /**
     * Default constructor
     */
    
    public Quimico() {
        
    }
    public Quimico(String nombre) {

        this.nombre = nombre;
    }

 

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }    
//
//    public List<Residuo> getListaResiduos() {
//        return listaResiduos;
//    }
//
//    public void setListaResiduos(List<Residuo> listaResiduos) {
//        this.listaResiduos = listaResiduos;
//    }

}