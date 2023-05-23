package Controlador;


import data.Perro;
import data.PerroDAO;
import java.util.List;

/**
 *
 * @author Rober y Cris
 */
public class Controlador {
    PerroDAO pD;

    public Controlador() {
        pD=new PerroDAO();
    }
    
    public void insertarJuego(Perro p) throws Exception{
        pD.insertarPerro(p);
    }
    public void modificarPerro(Perro p) throws Exception{
        pD.modificarPerro(p);
    }
    public void borrarPerro(Perro p) throws Exception{
        pD.eliminarPerro(p);
    }

    public List<Perro> listaPerros() {
       return pD.cargaTodosLosDatos();
    }

    public List<Perro> perrosPorNombre(Perro p) {
        return pD.buscarPerroPorNombre(p);
    }

    public List<Perro> perrosPorRaza(Perro p) {
        return pD.buscarPerroPorRaza(p);
    }
     public List<Perro> perrosConCondicion(String condicion,String atributo) {
        return pD.buscarPerroConCondicion(condicion,atributo);
    }
    
    public void cerrarSesion(){
        pD.cerrarSesion();
    }
}
