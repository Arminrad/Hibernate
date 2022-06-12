package hibernate;

import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Main {
    public static void main(String[] args) {
/*        var registry = new StandardServiceRegistryBuilder()
                .configure() // fetches configuration from hibernate.cfg.xml
                .build();
        // registry is useful for creating session factory
        // session Factory is a heavyweight object
        // session Factory is thread safe
        // session Factory is immutable
        // we work with database through session
        // session is similar to the connection to database
        var sessionFactory = new MetadataSources(registry)
                .addAnnotatedClass(Contact.class)
                .buildMetadata()
                .buildSessionFactory();*/

        var sessionFactory = SessionFactorySingleton.getInstance();
        var contact = new Contact(1l, "siavosh", "armin", "09304714334", "asda" );

        var session = sessionFactory.openSession();
        var transaction = session.beginTransaction();
        try {
            session.save(contact);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
        session.close();
    }
}
