package hibernate;

import java.util.List;

public interface ContactRepository {
    Contact save(Contact contact);
    void update(Contact contact);
    void delete(Contact contact);
    Contact findById(Long id);
    List<Contact> findAll();
}
