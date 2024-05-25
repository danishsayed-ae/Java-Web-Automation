package pageTests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;
import pageObjects.LoginObject;

public class LoginTest extends BaseTest {
    LoginObject loginObject;

    @Test
    public void adminLoginTest() throws InterruptedException {
        loginObject = new LoginObject(driver);
        loginObject.adminLogin("admin.utm","UTMe&@2024#$");
    }


}
