package Base;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class Base {

    public WebDriver driver;
    public String baseUrl = "https://www.nesine.com";

    public Base() {
        System.setProperty("webdriver.chrome.driver", "src/chromedriver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        }


    public void geturl() {
        driver.get(baseUrl);

    }

    public void DriverQuit() {
        driver.close();
    }

}
