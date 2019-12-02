import dao.Dao;
import dao.EmployeeDao;
import entities.Employee;
import utils.DaoUtil;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static utils.SystemUtil.print;

public class Runner {


    public void run() {
//        selectAll(EmployeeDao.class);
        selectAny(EmployeeDao.class, Arrays.asList(new Integer[]{1, 2, 3, 4, 5}));
    }

    private void selectAll(Class<? extends Dao> dao) {
        try {
            List<Employee> employeeList = DaoUtil.getDao(dao).all();
            employeeList.forEach(employee -> print(employee.toString()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void selectAny(Class<? extends Dao> dao, List<Integer> idList) {
        try {
            List<Employee> employeeList = DaoUtil.getDao(dao).selectAny(idList);
            employeeList.forEach(employee -> print(employee.toString()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    private void buildInsert() {
//        int dividePoint = 100;
//        try {
//            List<Employee> employeeList = new ArrayList<>();
//            try(
//                    Stream<Employee> stream = Files.lines(
//                            Paths.get(this.getClass().getResource("import/employee.csv").toURI())
//                            , StandardCharsets.UTF_8
//                    ).skip(1).map(row ->
//                            new Employee(
//                                    null
//                                    , row.split(Pattern.quote(","))[1]
//                                    , row.split(Pattern.quote(","))[2]
//                                    , row.split(Pattern.quote(","))[3]
//                                    , row.split(Pattern.quote(","))[4]
//                            )
//                    )
//            ) {
//                AtomicInteger loopCounter = new AtomicInteger(1);
//                stream.forEach(employee -> {
//                    employeeList.add(employee);
//                    // 分割点の倍数の場合インサートする
//                    if (loopCounter.get() % dividePoint == 0) {
//                        System.out.println("インサート行番号" + loopCounter);
//                        employeeDao.insetList(employeeList);
//                        employeeList.clear();
//                    }
//                    loopCounter.set(loopCounter.incrementAndGet());
//                });
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
}
