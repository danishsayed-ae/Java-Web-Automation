package tests;

import configuration.DefaultConfiguration;
import configuration.ScreenshotConfiguration;
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

import static configuration.DefaultConfiguration.environment;
import static configuration.ExtentReportConfiguration.getReport;

public class BaseTest {
    //    Initializing objects
    protected WebDriver driver;
    protected String browser;

    //    Initializing objects for each browser class
    ChromeOptions co = new ChromeOptions();
    EdgeOptions eo = new EdgeOptions();
    FirefoxOptions fo = new FirefoxOptions();

    //    It helps us to create independent thread during execution
    protected static ThreadLocal<ExtentTest> testLogger = new ThreadLocal<>();

    protected static final ExtentReports extentReports = getReport();

    private static final Logger logger = LogManager.getLogger(BaseTest.class);

    //    Using "Parameter" annotation by TestNG to enable parallel execution with different browsers
    @Parameters({"browserName"})

//    Using "BeforeMethod" annotation by TestNG to set up the test environment
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
//        Chrome browser
        if (browser.equalsIgnoreCase("chrome")) {
//            This will run the tests in local environment
            if (DefaultConfiguration.environment.equalsIgnoreCase("local")) {
//                co.addArguments("--remote-allow-origins=*");
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();

//            This will run the tests in remote environment inside Docker Standalone containers
            } else if (DefaultConfiguration.environment.equalsIgnoreCase("docker-compose-standalone")) {
                co.setPlatformName("linux");
                co.setPageLoadStrategy(PageLoadStrategy.EAGER);

//                Docker-Compose-Standalone URL
                driver = new RemoteWebDriver(new URL("http://localhost:4441/"), co);

//             This will run the tests in remote environment inside Docker Selenium Grid/Hub containers
            } else if (DefaultConfiguration.environment.equalsIgnoreCase("docker-compose-grid")) {
                co.setPlatformName("linux");
                co.setPageLoadStrategy(PageLoadStrategy.EAGER);

//                Docker-Compose-Grid URL
                driver = new RemoteWebDriver(new URL("http://localhost:4444/"), co);

//                This will run the tests in remote environment inside jenkins
            } else if (DefaultConfiguration.environment.equalsIgnoreCase("jenkins")) {
                co.setPlatformName("linux");
                co.setPageLoadStrategy(PageLoadStrategy.EAGER);

//                Jenkins URL - Danish Home
                driver = new RemoteWebDriver(new URL("http://192.168.0.196:4444/wd/hub"), co);

//                Jenkins URL - Danish Office Laptop
                driver = new RemoteWebDriver(new URL("http://192.168.0.126:4444/wd/hub"), co);

//                This will run the test in remote environment with GitHub Actions for CI/CD
            } else if (DefaultConfiguration.environment.equalsIgnoreCase("GitHubActions")) {
//                For GitHub Actions
                co.addArguments("--headless");
                co.addArguments("--disable-gpu");
                co.addArguments("--no-sandbox");
                WebDriverManager.chromedriver().setup();
//                co.addArguments("--remote-allow-origins=*");
                driver = new ChromeDriver(co);
            } else {
                logger.error(environment + "This environment is not supported !!");
            }


//            Firefox browser
        } else if (browser.equalsIgnoreCase("firefox")) {
//            This will run the tests in local environment
            if (environment.equalsIgnoreCase("local")) {
//                fo.addArguments("--remote-allow-origins=*");
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();

//                This will run the tests in remote environment inside Docker Standalone containers
            } else if (environment.equalsIgnoreCase("docker-compose-standalone")) {
                fo.setPlatformName("linux");
                fo.setPageLoadStrategy(PageLoadStrategy.EAGER);

//                Docker-Compose-Standalone URL
                driver = new RemoteWebDriver(new URL("http://localhost:4442/"), fo);

//                This will run the tests in remote environment inside Docker Selenium Grid/Hub containers
            } else if (environment.equalsIgnoreCase("docker-compose-grid")) {
                fo.setPlatformName("linux");
                fo.setPageLoadStrategy(PageLoadStrategy.EAGER);

//                Docker-Compose-Grid URL
                driver = new RemoteWebDriver(new URL("http://localhost:4444/"), fo);

//              This will run the tests in remote environment inside jenkins
            } else if (environment.equalsIgnoreCase("jenkins")) {
                fo.setPlatformName("linux");
                fo.setPageLoadStrategy(PageLoadStrategy.EAGER);

//                Jenkins URL - Danish Home
                driver = new RemoteWebDriver(new URL("http://192.168.0.196:4444/wd/hub"), fo);

//                Jenkins URL - Danish Office Laptop
                driver = new RemoteWebDriver(new URL("http://192.168.0.126:4444/wd/hub"), fo);

//             This will run the test in remote environment with GitHub Actions for CI/CD
            } else if (DefaultConfiguration.environment.equalsIgnoreCase("GitHubActions")) {
//                For GitHub Actions
                fo.addArguments("--headless");
                fo.addArguments("--disable-gpu");
                fo.addArguments("--no-sandbox");
                WebDriverManager.firefoxdriver().setup();
//                fo.addArguments("--remote-allow-origins=*");
                driver = new FirefoxDriver(fo);
            } else {
                logger.error(environment + "This environment is not supported !!");
            }


//        Edge browser
        } else if (browser.equalsIgnoreCase("edge")) {
//            This will run the tests in local environment
            if (environment.equalsIgnoreCase("local")) {
//                eo.addArguments("--remote-allow-origins=*");
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();

//                This will run the tests in remote environment inside Docker Standalone containers
            } else if (environment.equalsIgnoreCase("docker-compose-standalone")) {
                eo.setPlatformName("linux");
                eo.setPageLoadStrategy(PageLoadStrategy.EAGER);

//                Docker-Compose-Standalone URL
                driver = new RemoteWebDriver(new URL("http://localhost:4443/"), eo);

//                This will run the tests in remote environment inside Docker Selenium Grid/Hub containers
            } else if (environment.equalsIgnoreCase("docker-compose-grid")) {
                eo.setPlatformName("linux");
                eo.setPageLoadStrategy(PageLoadStrategy.EAGER);

//                Docker-Compose-Grid URL
                driver = new RemoteWebDriver(new URL("http://localhost:4444/"), eo);

//                This will run the tests in remote environment inside jenkins
            } else if (environment.equalsIgnoreCase("jenkins")) {
                eo.setPlatformName("linux");
                eo.setPageLoadStrategy(PageLoadStrategy.EAGER);

//                Jenkins URL - Danish Home
                driver = new RemoteWebDriver(new URL("http://192.168.0.196:4444/wd/hub"), eo);

//                Jenkins URL - Danish Office Laptop
                driver = new RemoteWebDriver(new URL("http://192.168.0.126:4444/wd/hub"), eo);

//                This will run the test in remote environment with GitHub Actions for CI/CD
            } else if (DefaultConfiguration.environment.equalsIgnoreCase("GitHubActions")) {
//                For GitHub Actions
                eo.addArguments("--headless");
                eo.addArguments("--disable-gpu");
                eo.addArguments("--no-sandbox");
                WebDriverManager.edgedriver().setup();
//                eo.addArguments("--remote-allow-origins=*");
                driver = new EdgeDriver(eo);

            } else {
                logger.error(environment + "This environment is not supported !!");
            }

        } else {
            logger.info("This browser is not supported !!");
        }

//        It will capture the method name of every test execution
        ExtentTest extentTest = extentReports.createTest(iTestResult.getMethod().getMethodName());
//        It will set the test in the Thread Local
        testLogger.set(extentTest);
        testLogger.get().log(Status.INFO, "Driver Start Time: " + LocalDateTime.now());
    }

    //    Using "AfterMethod" annotation by TestNG to teardown the test environment
    @AfterMethod
    public void tearDownTest(ITestResult iTestResult) throws IOException {
//        We will capture the test execution result before we quit the browser
        if (iTestResult.isSuccess()) {
//            Markup helps to beautify the result by adding a label and color to it
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
