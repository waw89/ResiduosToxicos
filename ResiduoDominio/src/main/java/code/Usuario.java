package code;
import java.util.*;

/**
 * 
 */
public class Usuario {

    /**
     * Default constructor
     */

    /**
     * 
     */
    private String tipo;

    /**
     * 
     */
    private String nombre;

    /**
     * 
     */
    private String usuario;

    /**
     * 
     */
    private String password;
    public Usuario() {
    }

    public Usuario(String tipo, String nombre) {
        this.tipo = tipo;
        this.nombre = nombre;
    }

    public Usuario(String tipo, String nombre, String usuario, String password) {
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

    @Override
    public String toString() {
        return "Usuario{" + "tipo=" + tipo + ", nombre=" + nombre + ", usuario=" + usuario + ", password=" + password + '}';
    }

}