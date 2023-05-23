
package data;
import GUI.Ventana;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rober
 */
public class PruebaExamen {

    public static void main(String[] args) {
        try {
            Ventana v=new Ventana();
            v.setVisible(true);
        } catch (Exception ex) {
            Logger.getLogger(PruebaExamen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
