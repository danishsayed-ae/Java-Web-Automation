package tests;

import data.LoginDataProvider;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import org.openqa.selenium.By;

public class LoginTest extends BaseTest {

    @Test(dataProvider = "loginData", dataProviderClass = LoginDataProvider.class)
    public void testUserLogin(String username, String password) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.performUserLogin(username, password);

        // Assertion
        boolean isLoggedIn = isElementPresent(By.xpath("//a[contains(text(),'Logout')]"));
        if (isLoggedIn) {
            Assert.assertTrue(isLoggedIn, "Login failed for valid credentials.");
        } else {
            Assert.fail("Test failed intentionally: Login should not be successful with incorrect credentials.");
        }
    }

    // Helper method to check the presence of an element
    private boolean isElementPresent(By locator) {
        try {
            driver.findElement(locator);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
