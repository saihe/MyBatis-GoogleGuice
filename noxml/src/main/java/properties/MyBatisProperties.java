package properties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MyBatisProperties extends BaseProperties {
    private String environmentId;
    private String driver;
    private String url;
    private String schema;
    private String username;
    private String password;
    private String autocommit;
    private String derbyCreate;

    public MyBatisProperties init() {
        return yaml.loadAs(
                ClassLoader.getSystemResourceAsStream(propertiesMap.get("mybatis"))
                , MyBatisProperties.class
        );
    }
}
