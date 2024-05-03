package PageTests;

import Base.AppConstants;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {
    protected WebDriver driver;
    protected String browser;
    private ChromeOptions co;
    private ChromeOptions fo;

    @BeforeTest
    public void setupTest()
    {
        browser = AppConstants.browserName;
        if(browser.equalsIgnoreCase("chrome"))
        {
            if(AppConstants.platform.equalsIgnoreCase("local"))
            {
//                co.addArguments("--remote-allow-origins=*");
                WebDriverManager.chromedriver().setup();
//                driver = new ChromeOptions();
            }
        }
        else if (browser.equalsIgnoreCase("firefox"))
        {
            if(AppConstants.platform.equalsIgnoreCase("local"))
            {
                fo.addArguments("--remote-allow-origins=*");
                WebDriverManager.firefoxdriver().setup();
//                driver = new FirefoxDriver(fo);
            }
        }
        else
        {
            System.out.println("Browsername is not supported!!!");
        }
    }

    @AfterTest
    public void tearDownTest()
    {
        driver.quit();
    }
}
