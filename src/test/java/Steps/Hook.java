package Steps;

import Base.BaseUtil;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.chrome.ChromeDriver;



public class Hook extends BaseUtil {

    private BaseUtil base;

    public Hook(BaseUtil base) {
        this.base = base;
    }

    @Before
    public void InitializeTest()
    {
        System.out.println("Open the Browser");
        //Chrome
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\selca\\Desktop\\chromedriver94.exe");
        base.Driver = new ChromeDriver();
        //Firefox
//
//        System.setProperty("webdriver.firefox.marionette", "C:\\Users\\selca\\Desktop\\Crizel Desktop File\\geckodriver.exe");
//        Driver = new FirefoxDriver();


    }
    @After
    public void TeardownTest(Scenario scenario)
    {
        if(scenario.isFailed())
        {
            //Take Screenshot
            System.out.println("Scenario Failed");
//            Driver.quit();
        }
        System.out.println("Close the Browser");
    }
}
