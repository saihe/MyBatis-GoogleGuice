package mapper;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.name.Names;
import dao.Dao;
import dao.EmployeeDao;
import entities.Employee;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.mybatis.guice.MyBatisModule;
import org.mybatis.guice.datasource.builtin.PooledDataSourceProvider;
import org.mybatis.guice.datasource.helper.JdbcHelper;
import utils.DaoUtil;

import java.util.List;

public interface EmployeeMapper {
    default String test() {
        return "test";
    }

    @Select("select id, name, mail, department_id from employee")
    List<Employee> all();
}
