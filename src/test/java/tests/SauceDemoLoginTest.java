package tests;

import pages.SauceDemoLoginPage;
import pages.SauceDemoProductPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

public class SauceDemoLoginTest extends BaseTest {
    SauceDemoLoginPage sauceDemoLoginPage;
    SauceDemoProductPage sauceDemoProductPage;

    private static final Logger logger = LogManager.getLogger(SauceDemoLoginTest.class);

    @Test
    public void userLoginTest() throws InterruptedException {
        sauceDemoLoginPage = new SauceDemoLoginPage(driver);
        sauceDemoProductPage = new SauceDemoProductPage(driver);
        sauceDemoLoginPage.userLogin("standard_user","secret_sauce");
    }
}
