package PageTests;

import Base.AppConstants;
import Base.BasePage;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.IOException;
import java.time.LocalDateTime;

import static Utilities.ExtentReportHelper.getReport;

public class BaseTest {
    protected WebDriver driver;
    protected String browser;

//    It helps us to create independent thread
    protected static ThreadLocal<ExtentTest> testLogger = new ThreadLocal<>();

    protected static final ExtentReports extentReports = getReport();

    private static final Logger logger = LogManager.getLogger(BaseTest.class);

    @Parameters({"browserName"})

    @BeforeMethod
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
        logger.info("Browser name is " +browser);

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
            logger.info("Browser name is not supported!");
        }
        ExtentTest extentTest = extentReports.createTest(iTestResult.getMethod().getMethodName());
        testLogger.set(extentTest);
        testLogger.get().log(Status.INFO, "Driver Start Time: "+ LocalDateTime.now());
    }

    @AfterMethod
    public void tearDownTest(ITestResult iTestResult) throws IOException {
        if (iTestResult.isSuccess())
        {
            testLogger.get().log(Status.PASS, MarkupHelper.createLabel(iTestResult.getMethod().getMethodName()+ " is successfully passed.", ExtentColor.GREEN));
        }
        else
        {
            testLogger.get().log(Status.FAIL, "Test is failed due to: "+iTestResult.getThrowable());
            String screenshot = BasePage.getScreenshot(iTestResult.getMethod().getMethodName()+".jpg", driver);
            testLogger.get().fail(MediaEntityBuilder.createScreenCaptureFromBase64String(BasePage.convertImg_Base64(screenshot)).build());
            testLogger.get().log(Status.INFO, "Driver End Time: "+LocalDateTime.now());
        }
        driver.quit();
    }

    @AfterClass
    public void flushTestReport()
    {
        extentReports.flush();
    }
}
