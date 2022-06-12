package hibernate;

import org.hibernate.SessionFactory;

import java.util.List;

public class ContactRepositoryImpl implements ContactRepository {

    private final SessionFactory sessionFactory = SessionFactorySingleton.getInstance();

    @Override
    public void save(Contact contact) {
        try (var session = sessionFactory.openSession()) {
            var transaction = session.beginTransaction();
            try {
                session.save(contact);
                transaction.commit();
            } catch (Exception e) {
                transaction.rollback();
                throw e;
            }
        }
    }

    @Override
    public void update(Contact contact) {
        try (var session = sessionFactory.openSession()) {
            var transaction = session.beginTransaction();
            try {
                session.update(contact);
                transaction.commit();
            } catch (Exception e) {
                transaction.rollback();
                throw e;
            }
        }
    }

    @Override
    public void delete(Contact contact) {
        try (var session = sessionFactory.openSession()) {
            var transaction = session.beginTransaction();
            try {
                session.delete(contact);
                transaction.commit();
            } catch (Exception e) {
                transaction.rollback();
                throw e;
            }
        }
    }

    @Override
    public Contact findById(Long id) {
        try (var session = sessionFactory.openSession()) {
            return session.find(Contact.class, id);
        }
    }

    @Override
    public List<Contact> findAll() {
        try (var session = sessionFactory.openSession()) {
            return null;
        }
    }
}
