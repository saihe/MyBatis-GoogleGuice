package modules;

import com.google.inject.name.Names;
import mapper.EmployeeMapper;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.mybatis.guice.datasource.builtin.PooledDataSourceProvider;
import properties.MyBatisProperties;

import java.util.Properties;

public class MyBatisModule extends org.mybatis.guice.MyBatisModule {
    @Override
    protected void initialize() {
        // MyBatis用設定
        Properties properties = new Properties();
        MyBatisProperties myBatisProperties = new MyBatisProperties().init();
        properties.setProperty("mybatis.environment.id", myBatisProperties.getEnvironmentId());
        properties.setProperty("JDBC.driver", myBatisProperties.getDriver());
        properties.setProperty("JDBC.url", myBatisProperties.getUrl());
        properties.setProperty("JDBC.schema", myBatisProperties.getSchema());
        properties.setProperty("JDBC.username", myBatisProperties.getUsername());
        properties.setProperty("JDBC.password", myBatisProperties.getPassword());
        properties.setProperty("JDBC.autoCommit", myBatisProperties.getAutocommit());
        properties.setProperty("derby.create", myBatisProperties.getDerbyCreate());

        // 設定反映
        Names.bindProperties(binder(), properties);

        // その他必要なバインド
        bindTransactionFactoryType(JdbcTransactionFactory.class);
        bindDataSourceProviderType(PooledDataSourceProvider.class);

        // エイリアス定義
        addSimpleAliases("org.mybatis.scripting.freemarker.FreeMarkerLanguageDriver");

        // マッパークラス定義
        addMapperClass(EmployeeMapper.class);
    }
}
