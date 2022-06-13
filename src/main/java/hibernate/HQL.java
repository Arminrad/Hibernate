package hibernate;

import org.hibernate.query.Query;

import java.util.List;

public class HQL {
    public static void main(String[] args) {

        var sessionFactory = SessionFactorySingleton.getInstance();

        var session = sessionFactory.openSession();

        ContactRepository contactRepository = new ContactRepositoryImpl();

        var contact = new Contact(null, "siavosh", "armin", "09304714334", "tehran" );
        var contact1 = new Contact(null, "s1", "arm", "09304715434", "tehran" );
        var contact2 = new Contact(null, "si", "armi", "09304765334", "tehran" );

        contactRepository.save(contact);
        contactRepository.save(contact1);
        contactRepository.save(contact2);


        // SELECT * FROM
        String hql = "FROM hibernate.Contact";
        Query<Contact> query = session.createQuery(hql, Contact.class);
        List<Contact> contacts = query.list();
        contacts
                .forEach(System.out::println);
    }
}
