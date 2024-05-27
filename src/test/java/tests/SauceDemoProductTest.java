package tests;

import pages.SauceDemoLoginPage;
import pages.SauceDemoProductPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

public class SauceDemoProductTest extends BaseTest{
    SauceDemoLoginPage sauceDemoLoginPage;
    SauceDemoProductPage sauceDemoProductPage;

    private static final Logger logger = LogManager.getLogger(SauceDemoProductTest.class);

    @Test
    public void testProductName() throws InterruptedException {
        sauceDemoLoginPage = new SauceDemoLoginPage(driver);
        sauceDemoProductPage = new SauceDemoProductPage(driver);
        sauceDemoLoginPage.userLogin("performance_glitch_user","secret_sauce");
        Thread.sleep(3000);
        logger.info(sauceDemoProductPage.getTitleOfPage());
        logger.info(sauceDemoProductPage.getProductName());
    }
}
