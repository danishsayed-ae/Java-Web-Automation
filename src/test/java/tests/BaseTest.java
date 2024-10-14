package tests;

import Configuration.DefaultConfiguration;
import Configuration.ScreenshotConfiguration;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDateTime;

import static Configuration.DefaultConfiguration.platform;
import static utils.ExtentReportHelper.getReport;

public class BaseTest {
//    Initializing objects
    protected WebDriver driver;
    protected String browser;

//    Initializing objects for each browser class
    ChromeOptions co = new ChromeOptions();
    EdgeOptions eo = new EdgeOptions();
    FirefoxOptions fo = new FirefoxOptions();

//    It helps us to create independent thread
    protected static ThreadLocal<ExtentTest> testLogger = new ThreadLocal<>();

    protected static final ExtentReports extentReports = getReport();

    private static final Logger logger = LogManager.getLogger(BaseTest.class);

//    Using "Parameter" annotation by TestNG to enable parallel execution with different browsers
    @Parameters({"browserName"})

//    Using "BeforeMethod" annotation by TestNG to setup the test environment
    @BeforeMethod
    public void setupTest(@Optional String browserName, ITestResult iTestResult) throws MalformedURLException {
//        Added a condition to check if we are receiving browserName from TestNG.xml file
        if (browserName != null) {
            browser = browserName;
        } else {
            browser = DefaultConfiguration.browserName;
        }
//        Printing the browserName for each execution
        logger.info("Browser name is: " + browser);

//        Added this condition to execute the tests using parameters from Maven Surefire plugin
        if (browser.equalsIgnoreCase("chrome")) {
            if (DefaultConfiguration.platform.equalsIgnoreCase("local")) {
//                co.addArguments("--remote-allow-origins=*");
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
            } else if (DefaultConfiguration.platform.equalsIgnoreCase("remote")) {
                co.setPlatformName("linux");
                co.setPageLoadStrategy(PageLoadStrategy.EAGER);

//                Docker-Compose_Grid URL
//                driver = new RemoteWebDriver(new URL("http://localhost:4444/"), co);

//                Docker-Compose_Standalone URL
//                driver = new RemoteWebDriver(new URL("http://localhost:4441/"), co);

//                Jenkins URL - Danish Home
                driver = new RemoteWebDriver(new URL("http://192.168.0.196:4444/wd/hub"), co);

//                Jenkins URL - Danish Office Laptop
//                driver = new RemoteWebDriver(new URL("http://192.168.0.126:4444/wd/hub"), co);


            } else if (DefaultConfiguration.platform.equalsIgnoreCase("remote_git")) {
//                For GitHub Actions
                co.addArguments("--headless");
                co.addArguments("--disable-gpu");
                co.addArguments("--no-sandbox");
                WebDriverManager.chromedriver().setup();
//                co.addArguments("--remote-allow-origins=*");
                driver = new ChromeDriver(co);
            } else {
                logger.error(platform + "This platform is not supported!");
            }

//            Firefox browser
        } else if (browser.equalsIgnoreCase("firefox")) {
            if (platform.equalsIgnoreCase("local")) {
//                fo.addArguments("--remote-allow-origins=*");
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
            } else if (platform.equalsIgnoreCase("remote")) {
                fo.setPlatformName("linux");
                fo.setPageLoadStrategy(PageLoadStrategy.EAGER);
//                Docker-Compose_Grid URL
//                driver = new RemoteWebDriver(new URL("http://localhost:4444/"), fo);

//                Docker-Compose_Standalone URL
//                driver = new RemoteWebDriver(new URL("http://localhost:4442/"), fo);

//                Jenkins URL - Danish Home
                driver = new RemoteWebDriver(new URL("http://192.168.0.196:4444/wd/hub"), fo);

//                Jenkins URL - Danish Office Laptop
//                driver = new RemoteWebDriver(new URL("http://192.168.0.126:4444/wd/hub"), fo);


            } else if (DefaultConfiguration.platform.equalsIgnoreCase("remote_git")) {
//                For GitHub Actions
                fo.addArguments("--headless");//For GitHub Actions
                fo.addArguments("--disable-gpu");
                fo.addArguments("--no-sandbox");
                WebDriverManager.firefoxdriver().setup();
//                fo.addArguments("--remote-allow-origins=*");
                driver = new FirefoxDriver(fo);
            } else {
                logger.error(platform + "This platform is not supported!");
            }

//            Edge browser
        } else if (browser.equalsIgnoreCase("edge")) {
            if (platform.equalsIgnoreCase("local")) {
//                eo.addArguments("--remote-allow-origins=*");
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
            } else if (platform.equalsIgnoreCase("remote")) {
                eo.setPlatformName("linux");
                eo.setPageLoadStrategy(PageLoadStrategy.EAGER);

//                Docker-Compose_Grid URL
//                driver = new RemoteWebDriver(new URL("http://localhost:4444/"), eo);

//                Docker-Compose_Standalone URL
//                driver= new RemoteWebDriver(new URL("http://localhost:4443/"), eo);

//                Jenkins URL - Danish Home
                driver = new RemoteWebDriver(new URL("http://192.168.0.196:4444/wd/hub"), eo);

//                Jenkins URL - Danish Office Laptop
//                driver = new RemoteWebDriver(new URL("http://192.168.0.126:4444/wd/hub"), eo);


            } else if (DefaultConfiguration.platform.equalsIgnoreCase("remote_git")) {
//                For GitHub Actions
                eo.addArguments("--headless");
                eo.addArguments("--disable-gpu");
                eo.addArguments("--no-sandbox");
                WebDriverManager.edgedriver().setup();
//                eo.addArguments("--remote-allow-origins=*");
                driver = new EdgeDriver(eo);
            } else {
                logger.error(platform + "This platform is not supported!");
            }
        } else {
            logger.info("Browser name is not supported!");
        }
        ExtentTest extentTest = extentReports.createTest(iTestResult.getMethod().getMethodName());
        testLogger.set(extentTest);
        testLogger.get().log(Status.INFO, "Driver Start Time: " + LocalDateTime.now());
    }

//    Using "AfterMethod" annotation by TestNG to teardown the test environment
    @AfterMethod
    public void tearDownTest(ITestResult iTestResult) throws IOException {
        if (iTestResult.isSuccess()) {
            testLogger.get().log(Status.PASS, MarkupHelper.createLabel(iTestResult.getMethod().getMethodName() + " passed successfully.", ExtentColor.GREEN));
        } else {
            testLogger.get().log(Status.FAIL, "Test is failed due to: " + iTestResult.getThrowable());
            String screenshot = ScreenshotConfiguration.getScreenshot(iTestResult.getMethod().getMethodName() + ".jpg", driver);
            testLogger.get().fail(MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotConfiguration.convertImg_Base64(screenshot)).build());
            testLogger.get().log(Status.INFO, "Driver End Time: " + LocalDateTime.now());
        }
        driver.quit();
    }

    @AfterClass
    public void flushTestReport() {
        extentReports.flush();
    }
}
