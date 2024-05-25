package pageTests;

import pageObjects.LoginPageObject;
import pageObjects.ProductPageObject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import java.awt.*;

public class ProductPageTest extends BaseTest{
    LoginPageObject loginPageObject;
    ProductPageObject productPageObject;

    private static final Logger logger = LogManager.getLogger(ProductPageTest.class);

    @Test
    public void testProductName() throws InterruptedException {
        loginPageObject = new LoginPageObject(driver);
        productPageObject = new ProductPageObject(driver);
        loginPageObject.userLogin("performance_glitch_user","secret_sauce");
        Thread.sleep(3000);
        logger.info(productPageObject.getTitleOfPage());
        logger.info(productPageObject.getProductName());
    }
}
