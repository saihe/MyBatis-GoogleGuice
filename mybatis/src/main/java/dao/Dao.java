package dao;

import java.util.List;
import java.util.Map;

public interface Dao<T> {
    List<T> all();
    void insert(T t);
    void insetList(List<T> list);
}
