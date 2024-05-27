package tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends BaseTest {
    LoginPage loginPage;
    private static final Logger logger = LogManager.getLogger(LoginTest.class);

    @Test
    public void adminLoginTest1() throws InterruptedException {
        loginPage = new LoginPage(driver);
        loginPage.adminLogin("admin.utm","");
    }

    @Test
    public void adminLoginTest2() throws InterruptedException {
        loginPage = new LoginPage(driver);
        loginPage.adminLogin("admin","");
        Assert.assertEquals("Login", driver.getTitle());
    }

    @Test
    public void adminLoginTest3() throws InterruptedException {
        loginPage = new LoginPage(driver);
        loginPage.adminLogin("admin.utm","");
        Assert.assertEquals("Login", driver.getTitle());
    }


}
