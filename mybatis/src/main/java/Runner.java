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
//        List<Employee> employeeList = employeeDao.all();
//        employeeList.forEach(e -> print(e.toString()));
//        try {
//            employeeDao.insert(new Employee(
//                    null
//                    , "テスト"
//                    , "test@test.com"
//                    , 1
//            ));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
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
                        , Integer.parseInt(row.split(Pattern.quote(","))[3])
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
