package PageTests;

import PageObjects.LoginPageObject;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest {
    LoginPageObject loginPageObject;

    @Test
    public void userLoginTest()
    {
        loginPageObject = new LoginPageObject(driver);

    }
}
