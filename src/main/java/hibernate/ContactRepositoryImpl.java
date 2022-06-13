package hibernate;

import org.hibernate.SessionFactory;

import java.util.List;

public class ContactRepositoryImpl extends GenericRepositoryImpl<Contact, Long> implements ContactRepository {

    @Override
    public Contact findById(Long id) {
        try (var session = sessionFactory.openSession()) {
            return session.find(Contact.class, id);
        }
    }

    @Override
    public List<Contact> findAll() {
        try (var session = sessionFactory.openSession()) {
            return session.createNamedQuery("findAll", Contact.class).list();
        }
    }
}
