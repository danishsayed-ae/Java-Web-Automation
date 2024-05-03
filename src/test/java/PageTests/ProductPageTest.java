package PageTests;

import PageObjects.LoginPageObject;
import PageObjects.ProductPageObject;
import org.testng.annotations.Test;

public class ProductPageTest extends BaseTest{
    LoginPageObject loginPageObject;
    ProductPageObject productPageObject;

    @Test
    public void testProductName()
    {
        loginPageObject = new LoginPageObject(driver);
        productPageObject = new ProductPageObject(driver);
        loginPageObject.userLogin("performance_glitch_user","secret_sauce");
        System.out.println(productPageObject.getProductName());
    }
}
