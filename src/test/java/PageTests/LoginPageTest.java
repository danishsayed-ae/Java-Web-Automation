package PageTests;

import PageObjects.LoginPageObject;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest {
    LoginPageObject loginPageObject;

    @Test
    public void userLoginTest() throws InterruptedException {
        loginPageObject = new LoginPageObject(driver);
        loginPageObject.userLogin("standard_user","secret_sauce");
        Thread.sleep(5000);
    }
}
