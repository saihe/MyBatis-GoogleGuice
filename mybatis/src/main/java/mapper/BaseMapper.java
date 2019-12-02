package mapper;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BaseMapper<T> {
    List<T> all();
    List<T> selectAny(@Param("idList") List<Integer> idList);
    T selectOne();
    void insert(T entity);
    void insertList(List<T> entityList);
}
