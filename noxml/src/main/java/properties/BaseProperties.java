package properties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.yaml.snakeyaml.Yaml;

import java.util.HashMap;
import java.util.Map;

@Getter
@AllArgsConstructor
public abstract class BaseProperties {
    protected Yaml yaml;
    protected Map<String, String> propertiesMap;

    @SuppressWarnings("unchecked")
    public BaseProperties() {
        yaml = new Yaml();
        propertiesMap = (HashMap<String, String>) yaml.loadAs(
                ClassLoader.getSystemResourceAsStream("application.yml")
                , HashMap.class
        ).get("properties");
    }
}
