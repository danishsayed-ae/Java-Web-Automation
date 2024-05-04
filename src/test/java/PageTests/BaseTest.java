package PageTests;

import Base.AppConstants;
import PageObjects.LoginPageObject;
import PageObjects.ProductPageObject;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseTest {
    protected WebDriver driver;
    protected String browser;
    private ChromeOptions co;
    private FirefoxOptions fo;
    private EdgeOptions eo;

    @Parameters({"browserName"})


    @BeforeTest
    public void setupTest(@Optional String browserName)
    {
        if (browserName!=null)
        {
            browser = browserName;
        }
        else
        {
            browser = AppConstants.browserName;
        }
        System.out.println("Browser name is " +browser);

        if(browser.equalsIgnoreCase("chrome"))
        {
            if(AppConstants.platform.equalsIgnoreCase("local"))
            {
//                co.addArguments("--remote-allow-origins=*");
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
            }
        }
        else if (browser.equalsIgnoreCase("firefox"))
        {
            if(AppConstants.platform.equalsIgnoreCase("local"))
            {
//                fo.addArguments("--remote-allow-origins=*");
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
            }
        }
        else if (browser.equalsIgnoreCase("edge"))
        {
            if(AppConstants.platform.equalsIgnoreCase("local"))
            {
//                eo.addArguments("--remote-allow-origins=*");
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
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
