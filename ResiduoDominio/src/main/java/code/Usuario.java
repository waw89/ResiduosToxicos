package code;
import java.io.Serializable;
import java.util.*;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

/**
 * 
 */

@Entity
@Inheritance (strategy = InheritanceType.JOINED)
@DiscriminatorColumn (name = "Tipo")
@Table (name = "Usuario")
public class Usuario  {

    /**
     * 
     */
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    @Column (name = "id_Usuario")
    private long id;

    @Basic
    @Column (name = "Tipo")
    private String tipo;

    /**
     * 
     */
    @Basic
    @Column (name = "Nombre")
    private String nombre;

    /**
     * 
     */
    @Basic
    @Column (name = "nomUsuario")
    private String usuario;

    /**
     * 
     */
    @Basic
    @Column (name = "Contraseña")
    private String password;
    
    public Usuario() {
    }
    
    public Usuario( String tipo, String nombre, String usuario, String password) {
        this.tipo = tipo;
        this.nombre = nombre;
        this.usuario = usuario;
        this.password = password;
    }


    public Usuario(long id, String tipo, String nombre, String usuario, String password) {
        this.tipo = tipo;
        this.nombre = nombre;
        this.usuario = usuario;
        this.password = password;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
   public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    @Override
    public String toString() {
        return "Usuario{" + "tipo=" + tipo + ", nombre=" + nombre + ", usuario=" + usuario + ", password=" + password + '}';
    }

}