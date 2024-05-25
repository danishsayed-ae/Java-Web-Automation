package pageTests;

import pageObjects.LoginPageObject;
import pageObjects.ProductPageObject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import java.awt.*;

public class LoginPageTest extends BaseTest {
    LoginPageObject loginPageObject;
    ProductPageObject productPageObject;

    private static final Logger logger = LogManager.getLogger(LoginPageTest.class);

    @Test
    public void userLoginTest() throws InterruptedException, AWTException {
        loginPageObject = new LoginPageObject(driver);
        productPageObject = new ProductPageObject(driver);
        loginPageObject.userLogin("standard_user","secret_sauce");
        logger.info(productPageObject.getTitleOfPage());
    }
}
