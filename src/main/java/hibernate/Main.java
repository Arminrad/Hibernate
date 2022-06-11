package hibernate;

import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Main {
    public static void main(String[] args) {
        var registry = new StandardServiceRegistryBuilder()
                .configure() // fetches configuration from hibernate.cfg.xml
                .build();
        // registry is useful for creating session factory
        // session Factory is a heavyweight object
        // session Factory is thread safe
        // session Factory is immutable
        // we work with database through session
        var sessionFactory = new MetadataSources(registry)
                .buildMetadata()
                .buildSessionFactory();
    }
}
