package hibernate;

import java.util.List;

public interface ContactRepository {
    void save(Contact contact);
    void update(Contact contact);
    void delete(Contact contact);
    Contact findById(Long id);
    List<Contact> findAll();
}
