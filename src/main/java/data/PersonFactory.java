package data;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class PersonFactory {
    
    private static ServiceRegistry serviceRegistry;
    private static final SessionFactory sessionFactory;
 
    static {
        try {            
            Configuration configuration=new Configuration().configure("hibernate.cfg.xml"); 

            configuration.addAnnotatedClass(Perro.class);
            StandardServiceRegistryBuilder serviceRegistryBuilder = new StandardServiceRegistryBuilder();
            
            serviceRegistryBuilder.applySettings(configuration.getProperties());

            serviceRegistry = serviceRegistryBuilder.build();

            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        } catch (Throwable ex) {
            System.err.println("Fallo al crear sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
 
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
