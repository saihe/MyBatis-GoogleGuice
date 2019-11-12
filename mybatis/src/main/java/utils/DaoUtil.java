package utils;

import com.google.inject.Guice;
import com.google.inject.Injector;
import dao.Dao;
import org.mybatis.guice.XMLMyBatisModule;

public class DaoUtil {
    private Injector injector;
    private static DaoUtil inst = new DaoUtil();


    private DaoUtil() {
        injector = Guice.createInjector(new XMLMyBatisModule() {
            @Override
            protected void initialize() {}
        });
    }

    public static <T extends Dao<?>> T getDao(Class<T> clazz) {
        return inst.injector.getInstance(clazz);
    }}
