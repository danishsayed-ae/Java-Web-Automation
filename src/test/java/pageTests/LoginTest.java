package pageTests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.LoginObject;

public class LoginTest extends BaseTest {
    LoginObject loginObject;
    private static final Logger logger = LogManager.getLogger(LoginTest.class);

    @Test
    public void adminLoginTest1() throws InterruptedException {
        loginObject = new LoginObject(driver);
        loginObject.adminLogin("admin.utm","UTMe&@2024#$");
    }

    @Test
    public void adminLoginTest2() throws InterruptedException {
        loginObject = new LoginObject(driver);
        loginObject.adminLogin("admin","UTMe&@2024#$");
        Assert.assertEquals("Login", driver.getTitle());
    }

    @Test
    public void adminLoginTest3() throws InterruptedException {
        loginObject = new LoginObject(driver);
        loginObject.adminLogin("admin.utm","UTMe&@2024");
        Assert.assertEquals("Login", driver.getTitle());
    }


}
