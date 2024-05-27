package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import org.openqa.selenium.By;
import data.LoginDataProvider;

public class LoginTest1 extends BaseTest {

    @Test(dataProvider = "loginData", dataProviderClass = LoginDataProvider.class, priority = 1)
    public void testLogin(String username, String password, boolean isValid) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.userLogin(username, password);

        // Check login success or failure based on isValid flag
        boolean isLoggedIn = isElementPresent(By.xpath("//a[contains(text(),'Logout')]"));
        if (isValid) {
            Assert.assertTrue(isLoggedIn, "Login failed for valid credentials.");
        } else {
            Assert.assertTrue(isLoggedIn, "Login attempt was unsuccessful due to invalid credentials.");
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
