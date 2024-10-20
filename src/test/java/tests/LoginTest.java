package tests;

import dataProvider.LoginDataProvider;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import org.openqa.selenium.By;

public class LoginTest extends BaseTest {

    @Test(dataProvider = "loginDataFromJson", dataProviderClass = LoginDataProvider.class)
    public void testUserLogin(String username, String password) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.performUserLogin(username, password);

        // Assertion to check if logout button is displayed after successfully logging in
        boolean isLoggedIn = isElementPresent(By.xpath("//a[contains(text(),'Logout')]"));
        if (isLoggedIn) {
            Assert.assertTrue(isLoggedIn, "Test failed: Login should be successful with valid credentials.");
        } else {
            Assert.fail("Test failed intentionally: Login should not be successful with invalid credentials.");
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
