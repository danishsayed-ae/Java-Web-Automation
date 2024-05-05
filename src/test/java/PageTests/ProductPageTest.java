package PageTests;

import PageObjects.LoginPageObject;
import PageObjects.ProductPageObject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

public class ProductPageTest extends BaseTest{
    LoginPageObject loginPageObject;
    ProductPageObject productPageObject;

    private static final Logger logger = LogManager.getLogger(ProductPageTest.class);

    @Test
    public void testProductName()
    {
        loginPageObject = new LoginPageObject(driver);
        productPageObject = new ProductPageObject(driver);
        loginPageObject.userLogin("performance_glitch_user","secret_sauce");
        logger.info(productPageObject.getTitleOfPage());
        logger.info(productPageObject.getProductName());
    }
}
