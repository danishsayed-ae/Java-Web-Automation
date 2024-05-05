package PageTests;

import Base.AppConstants;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.internal.TestListenerHelper;

import java.time.LocalDateTime;

import static Utilities.ExtentReportHelper.getReport;

public class BaseTest {
    protected WebDriver driver;
    protected String browser;
    private ChromeOptions co;
    private FirefoxOptions fo;
    private EdgeOptions eo;
//    It helps us to create independent thread
    protected static ThreadLocal<ExtentTest> testLogger = new ThreadLocal<>();
    protected static final ExtentReports extentReports = getReport();


    @Parameters({"browserName"})


    @BeforeTest
    public void setupTest(@Optional String browserName, ITestResult iTestResult)
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
        ExtentTest extentTest = extentReports.createTest(iTestResult.getMethod().getMethodName());
        testLogger.set(extentTest);
        testLogger.get().log(Status.INFO, "Driver start time"+ LocalDateTime.now());
    }

    @AfterTest
    public void tearDownTest(ITestResult iTestResult)
    {
        if (iTestResult.isSuccess())
        {
            testLogger.get().log(Status.PASS, MarkupHelper.createLabel(iTestResult.getMethod().getMethodName()+ " is successfully passed", ExtentColor.GREEN));
        }
        else
        {
            testLogger.get().log(Status.FAIL, "Test is failed due to: "+iTestResult.getThrowable());
            String 
        }
        driver.quit();
    }
}
