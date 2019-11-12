package mapper;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;

public class AbstractMapper {
    public Injector getInjector(Class origin, Class target) {
        return Guice.createInjector(new AbstractModule() {
            @Override protected void configure() {
                bind(origin).to(target);
            }
        });
    }
}
