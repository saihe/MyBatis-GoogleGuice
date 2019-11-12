package utils;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.google.inject.name.Names;
import dao.Dao;
import entities.Employee;
import lombok.Getter;
import org.mybatis.guice.MyBatisModule;
import org.mybatis.guice.XMLMyBatisModule;
import org.mybatis.guice.datasource.helper.JdbcHelper;

import java.util.Properties;

public class DaoUtil {
    private Injector injector;
    private static DaoUtil inst = new DaoUtil();


    private DaoUtil() {
//        injector = Guice.createInjector(new XMLMyBatisModule() {
//            @Override
//            protected void initialize() {}
//        });

        Properties myBatisProperties = new Properties();
        myBatisProperties.setProperty("mybatis.environment.id", "test");
//        myBatisProperties.setProperty("JDBC.driver", "com.mysql.jdbc.Driver");
//        myBatisProperties.setProperty("JDBC.url", "lams-lbn.com:3306");
        myBatisProperties.setProperty("JDBC.schema", "test");
        myBatisProperties.setProperty("derby.create", "true");
        myBatisProperties.setProperty("JDBC.username", "test");
        myBatisProperties.setProperty("JDBC.password", "test");
        myBatisProperties.setProperty("JDBC.autoCommit", "false");

        injector = Guice.createInjector(
                JdbcHelper.MariaDB,
                binder -> Names.bindProperties(binder, myBatisProperties)
        );
    }

    public static <T extends Dao<?>> T getDao(Class<T> clazz) {
        return inst.injector.getInstance(clazz);
    }}
