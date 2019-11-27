package dao;

import java.util.List;

public interface Dao<T> {
    List<T> all();
    void insert(T t);
    void insetList(List<T> list);
}
