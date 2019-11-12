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
}
