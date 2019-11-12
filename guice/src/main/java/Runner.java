import com.google.inject.Inject;
import servicies.OrangeService;

import static utils.utils.SystemUtil.print;

public class Runner {
    @Inject
    private OrangeService orangeService;

    public void run() {
        print("run");
        print(orangeService.returnString());
    }
}
