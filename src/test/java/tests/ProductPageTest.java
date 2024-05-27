package tests;

import pages.SauceDemoLoginPage;
import pages.ProductPageObject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

public class ProductPageTest extends BaseTest{
    SauceDemoLoginPage sauceDemoLoginPage;
    ProductPageObject productPageObject;

    private static final Logger logger = LogManager.getLogger(ProductPageTest.class);

    @Test
    public void testProductName() throws InterruptedException {
        sauceDemoLoginPage = new SauceDemoLoginPage(driver);
        productPageObject = new ProductPageObject(driver);
        sauceDemoLoginPage.userLogin("performance_glitch_user","secret_sauce");
        Thread.sleep(3000);
        logger.info(productPageObject.getTitleOfPage());
        logger.info(productPageObject.getProductName());
    }
}
