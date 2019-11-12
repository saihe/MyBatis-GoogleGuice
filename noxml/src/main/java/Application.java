import com.google.inject.Guice;
import com.google.inject.Injector;
import modules.BaseModule;
import modules.MyBatisModule;

public class Application {

    public static void main(String[] args) {
        Injector injector = Guice.createInjector(
                new BaseModule()
                , new MyBatisModule()
        );
        injector.getInstance(Runner.class).run();
    }
}
