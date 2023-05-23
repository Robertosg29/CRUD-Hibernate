package data;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

/**
 *
 * @author Rober
 */
public class PerroDAO {

    private static SessionFactory sessionFactory;
    private static Session session;

    public PerroDAO() {
        sessionFactory = PersonFactory.getSessionFactory();
        session = sessionFactory.openSession();

    }

    public void cerrarSesion() {
        if (session != null) {
            session.close();
        }
        if (sessionFactory != null) {
            sessionFactory.close();
        }
    }

    public List<Perro> cargaTodosLosDatos() {

        Query qry = session.createQuery("from data.Perro");

        List<Perro> perros = qry.list();
        return perros;
    }

    public Perro buscarPerroPorId(Perro p) throws Exception {
        p = session.find(Perro.class, p.getId());
        if (p == null) {
            throw new Exception("No existe este perro");
        }
        return p;
    }

    public void insertarPerro(Perro p) throws Exception {
        boolean sinResultados = false;
        try {

            if (comprobarNombreRaza(p)) {
                sinResultados = true;
                session.getTransaction().begin();
                session.persist(p);
                session.getTransaction().commit();
            }

        } catch (Exception e) {
            e.printStackTrace(System.out);
            session.getTransaction().rollback();
            System.out.println("no ha funcionado insertar");
        }
        if (!sinResultados) {
            throw new Exception("No es posible añadir este perro, coincidencia nombre-raza");
        }
    }

    public void eliminarPerro(Perro p) throws Exception {
        p = buscarPerroPorId(p);
        try {
            session.getTransaction().begin();
            session.remove(session.merge(p));
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            session.getTransaction().rollback();
            System.out.println("no ha funcionado eliminar");
        }
    }

    public List<Perro> buscarPerroPorNombre(Perro p) {
        List<Perro> perros = new ArrayList<>();
        try {
            Query qry = session.createQuery("from data.Perro where nombre= :nombre");
            qry.setParameter("nombre", p.getNombre());
            perros = qry.list();
        } catch (Exception e) {
            System.out.println("Error en la busqueda.");
        }
        return perros;
    }

    public List<Perro> buscarPerroPorRaza(Perro p) {
        List<Perro> perros = new ArrayList<>();
        try {
            Query qry = session.createQuery("from data.Perro where raza= :raza");
            qry.setParameter("raza", p.getRaza());
            perros = qry.list();
        } catch (Exception e) {
            System.out.println("Error en la busqueda.");
        }
        return perros;
    }

    public void modificarPerro(Perro p) throws Exception {
        boolean modificarOk = false;
        try {
            if (comprobarNombreRazaId(p)) {
                session.getTransaction().begin();
                session.merge(p);
                session.getTransaction().commit();
                modificarOk = true;
            }

        } catch (Exception e) {
            e.printStackTrace(System.out);
            session.getTransaction().rollback();
            System.out.println("no ha funcionado modificar");
        }
        if (!modificarOk) {
            throw new Exception("No puedes modificar este perro, no puedes volver a repetir nombre y raza de otro animal");
        }
    }

    private boolean comprobarNombreRazaId(Perro p) {
        List<Perro> perros = new ArrayList<>();
        try {
            Query qry = session.createQuery("from data.Perro where nombre= :nombre");
            qry.setParameter("nombre", p.getNombre());
            perros = qry.list();
            if (perros.isEmpty()) {
                return true;
            } else {
                for (Perro pe : perros) {
                    if (p.getRaza().compareToIgnoreCase(pe.getRaza()) == 0) {
                        if (p.getId() == pe.getId()) {
                            return true;
                        } else {
                            return false;
                        }
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Error en la busqueda.");
        }
        return true;
    }

    private boolean comprobarNombreRaza(Perro p) {
        List<Perro> perros = new ArrayList<>();
        try {
            Query qry = session.createQuery("from data.Perro where nombre= :nombre");
            qry.setParameter("nombre", p.getNombre());
            perros = qry.list();
            if (perros.isEmpty()) {
                return true;
            } else {
                for (Perro pe : perros) {
                    if (p.getRaza().compareToIgnoreCase(pe.getRaza()) == 0) {
                        return false;
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Error en la busqueda.");
        }
        return true;
    }
    public List<Perro> buscarPerroConCondicion(String condicion,String atributo){
        
        List<Perro> perros = new ArrayList<>();     
        Query qry = session.createQuery("from data.Perro where "+atributo+" = ( SELECT "+condicion+"( "+atributo+" ) from data.Perro )");
        perros=qry.list();
        
        return perros;
        
    }
}
