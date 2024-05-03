package PageTests;

import PageObjects.LoginPageObject;
import PageObjects.ProductPageObject;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest {
    LoginPageObject loginPageObject;
    ProductPageObject productPageObject;

    @Test
    public void userLoginTest() throws InterruptedException {
        loginPageObject = new LoginPageObject(driver);
        productPageObject = new ProductPageObject(driver);
        loginPageObject.userLogin("standard_user","secret_sauce");
        System.out.println(productPageObject.getTitleOfPage());
    }
}
