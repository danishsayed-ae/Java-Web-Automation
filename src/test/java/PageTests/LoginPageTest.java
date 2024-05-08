package PageTests;

import PageObjects.LoginPageObject;
import PageObjects.ProductPageObject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest {
    LoginPageObject loginPageObject;
    ProductPageObject productPageObject;

    private static final Logger logger = LogManager.getLogger(LoginPageTest.class);

    @Test
    public void userLoginTest() throws InterruptedException {
        loginPageObject = new LoginPageObject(driver);
        productPageObject = new ProductPageObject(driver);
        loginPageObject.userLogin("standard_user","secret_sauce");
        logger.info(productPageObject.getTitleOfPage());
    }
}
