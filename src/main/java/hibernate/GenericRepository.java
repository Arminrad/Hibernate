package hibernate;

public interface GenericRepository<T, ID> {

    T save(T t);
    void update(T t);
    void delete(T t);
}
