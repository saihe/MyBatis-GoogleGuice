package dao;

import com.google.inject.Inject;
import entities.Employee;
import mapper.EmployeeMapper;

import java.util.List;

public class EmployeeDao implements Dao<Employee> {
    @Inject
    private EmployeeMapper mapper;

    @Override
    public List<Employee> all() {
        return mapper.all();
    }

    @Override
    public void insert(Employee employee) {
        mapper.insert(employee);
    }

    @Override
    public void insetList(List<Employee> list) {
        mapper.insertList(list);
    }

    @Override
    public List<Employee> selectAny(List<Integer> idList) {
        return mapper.selectAny(idList);
    }

    @Override
    public Employee selectOne() {
        return mapper.selectOne();
    }

    public List<Employee> select(List<Integer> idList) {
        return mapper.selectAny(idList);
    }
}
