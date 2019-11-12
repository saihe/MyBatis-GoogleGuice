package modules;

import com.google.inject.Binder;
import com.google.inject.name.Names;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import lombok.Getter;
import mapper.EmployeeMapper;
import org.apache.ibatis.datasource.DataSourceFactory;
import org.apache.ibatis.transaction.Transaction;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.apache.ibatis.transaction.managed.ManagedTransactionFactory;
import org.mybatis.guice.datasource.builtin.PooledDataSourceProvider;
import org.mybatis.guice.datasource.helper.JdbcHelper;

import javax.sql.DataSource;
import java.util.Properties;

public class MyBatisModule extends org.mybatis.guice.MyBatisModule {
    @Getter
    private Properties properties;

    public MyBatisModule() {
        properties = new Properties();
        properties.setProperty("mybatis.environment.id", "test");
        properties.setProperty("JDBC.driver", "com.mysql.jdbc.Driver");
        properties.setProperty("JDBC.url", "jdbc:mysql://lams-lbn.com:3306/test");
        properties.setProperty("JDBC.schema", "test");
        properties.setProperty("derby.create", "true");
        properties.setProperty("JDBC.username", "test");
        properties.setProperty("JDBC.password", "test");
        properties.setProperty("JDBC.autoCommit", "false");
    }

    @Override
    protected void initialize() {
//        install(JdbcHelper.MySQL);
        Names.bindProperties(binder(), properties);
        bindTransactionFactoryType(JdbcTransactionFactory.class);
        bindDataSourceProviderType(PooledDataSourceProvider.class);
//        bind(DataSource.class).toProvider(MysqlDataSource::new);
//        bind(TransactionFactory.class).to(ManagedTransactionFactory.class);
        addMapperClass(EmployeeMapper.class);
    }
}
