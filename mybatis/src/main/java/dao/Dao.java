package dao;

import java.util.List;

public interface Dao<T> {
    List<T> all();
    List<T> selectAny(List<Integer> idList);
    T selectOne();
    void insert(T t);
    void insetList(List<T> list);
}
