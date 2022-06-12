package hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class SessionFactorySingleton {

    private SessionFactorySingleton() {}

    private static class Holder {

        static SessionFactory INSTANCE;

        static {
            var registry = new StandardServiceRegistryBuilder()
                    .configure()
                    .build();
            INSTANCE = new MetadataSources(registry)
                    .addAnnotatedClass(Contact.class)
                    .buildMetadata()
                    .buildSessionFactory();
        }
    }
    public static SessionFactory getInstance() {
        return Holder.INSTANCE;
    }
}
