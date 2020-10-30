package Steps;

import Base.Base;
import cucumber.api.java.After;

public class Hook extends Base {

    @After
    public void tearDown(){
        DriverQuit();
    }

}
