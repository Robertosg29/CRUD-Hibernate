
package data;

import java.io.Serializable;
import java.util.logging.Logger;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Rober
 */
@Entity
@Table(name = "perros")
public class Perro implements Serializable{
    
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)   
    @Column(name = "id_perro")
    private int id;
    
    @Column(name = "nombre")
    private String nombre;
     
    @Column(name = "edad")
    private int edad;
      
    @Column(name = "raza")
    private String raza;

    public Perro(String nombre, int edad, String raza) {
        this.nombre = nombre;
        this.edad = edad;
        this.raza = raza;
    }

    public Perro() {
    }
    
    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    

    @Override
    public String toString() {
        return "Perro{" + "id=" + id + ", nombre=" + nombre + ", edad=" + edad + ", raza=" + raza + '}';
    }
    
    
}
