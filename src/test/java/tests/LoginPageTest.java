package tests;

import pages.SauceDemoLoginPage;
import pages.ProductPageObject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest {
    SauceDemoLoginPage sauceDemoLoginPage;
    ProductPageObject productPageObject;

    private static final Logger logger = LogManager.getLogger(LoginPageTest.class);

    @Test
    public void userLoginTest() throws InterruptedException {
        sauceDemoLoginPage = new SauceDemoLoginPage(driver);
        productPageObject = new ProductPageObject(driver);
        sauceDemoLoginPage.userLogin("standard_user","secret_sauce");
    }
}
