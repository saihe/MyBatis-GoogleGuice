import dao.EmployeeDao;
import entities.Employee;
import utils.utils.DaoUtil;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Runner {
    public void run() {
        int dividePoint = 100;
        EmployeeDao employeeDao = DaoUtil.getDao(EmployeeDao.class);
        try {
            List<Employee> employeeList = new ArrayList<>();
            try(
                    Stream<Employee> stream = Files.lines(
                            Paths.get(this.getClass().getResource("import/employee.csv").toURI())
                            , StandardCharsets.UTF_8
                    ).skip(1).map(row ->
                            new Employee(
                                    null
                                    , row.split(Pattern.quote(","))[1]
                                    , row.split(Pattern.quote(","))[2]
                                    , row.split(Pattern.quote(","))[3]
                                    , row.split(Pattern.quote(","))[4]
                            )
                    )
            ) {
                AtomicInteger loopCounter = new AtomicInteger(1);
                stream.forEach(employee -> {
                    employeeList.add(employee);
                    // 分割点の倍数の場合インサートする
                    if (loopCounter.get() % dividePoint == 0) {
                        System.out.println("インサート行番号" + loopCounter);
                        employeeDao.insetList(employeeList);
                        employeeList.clear();
                    }
                    loopCounter.set(loopCounter.incrementAndGet());
                });
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
