package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import org.openqa.selenium.By;

public class LoginTest extends BaseTest {

    @Test  (priority = 3)
    public void testPositiveFlow() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.userLogin("t.p1@yopmail.com", "Test@1234");

        // Add your assertion here for successful login
        // Example:
        boolean isLoggedIn = driver.findElement(By.xpath("//a[contains(text(),'Logout')]")).isDisplayed();
        Assert.assertTrue(isLoggedIn, "Login failed for valid credentials.");
    }

    @Test (priority = 1)
    public void testNegativeFlowIncorrectUsername() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.userLogin("ds@yopmail.com", "Test@1234");

        // Fail the test if login is successful
        boolean isLoggedIn = isElementPresent(By.xpath("//a[contains(text(),'Logout')]"));
        if (!isLoggedIn) {
            Assert.fail("Test failed intentionally: Login should not be successful with incorrect username.");
        }
    }

    @Test  (priority = 2)
    public void testNegativeFlowIncorrectPassword() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.userLogin("t.p1@yopmail.com", "Test@1");

        // Fail the test if login is successful
        boolean isLoggedIn = isElementPresent(By.xpath("//a[contains(text(),'Logout')]"));
        if (!isLoggedIn) {
            Assert.fail("Test failed intentionally: Login should not be successful with incorrect password.");
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
