import dao.EmployeeDao;
import entities.Employee;
import utils.utils.DaoUtil;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Runner {
    public void run() {
        EmployeeDao employeeDao = DaoUtil.getDao(EmployeeDao.class);
        try {
            List<Employee> employeeList = new ArrayList<>();
            try (
                    Stream<String> stream = Files.lines(
                            Paths.get(
                                    this.getClass().getResource("import/employee.csv").toURI())
                            , StandardCharsets.UTF_8
                    )
            ) {
                employeeList = stream.skip(1).map(row -> new Employee(
                        null
                        , row.split(Pattern.quote(","))[1]
                        , row.split(Pattern.quote(","))[2]
                        , row.split(Pattern.quote(","))[3]
                        , row.split(Pattern.quote(","))[4]
                )).collect(Collectors.toList());
            } catch (IOException e) {
                e.printStackTrace();
            }
            employeeDao.insetList(employeeList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
