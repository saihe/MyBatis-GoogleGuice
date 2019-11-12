import com.google.inject.AbstractModule;
import servicies.OrangeService;
import servicies.impl.OrangeServiceImpl;

public class BasicModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(Runner.class).toInstance(new Runner());
        bind(OrangeService.class).to(OrangeServiceImpl.class);
    }
}
