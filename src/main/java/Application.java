import dao.EmployeeDao;
import entities.Employee;
import utils.DaoUtil;

import java.util.List;

public class Application {

    public static void main(String args[]) {
        EmployeeDao employeeDao = DaoUtil.getDao(EmployeeDao.class);
        List<Employee> employeeList = employeeDao.all();
        employeeList.forEach(e -> print(e.toString()));
    }

    private static void print(String msg) {
        System.out.println(msg);
    }
}
