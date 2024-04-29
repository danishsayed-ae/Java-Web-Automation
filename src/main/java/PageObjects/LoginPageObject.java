package PageObjects;

import GenericKeywords.WebElementsInteractions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPageObject extends WebElementsInteractions
{
//    WebDriver driver;
    private final By userNameTextField = By.id("user-name");
    private final By passwordTextFiled = By.id("password");
    private final By loginButton = By.id("login-button");

    public void userLogin(String username, String password)
    {
//        driver.findElement(userNameTextField).sendKeys(username);
//        driver.findElement(passwordTextFiled).sendKeys(password);
//        driver.findElement(loginButton).click();
        goToApplication("https://www.saucedemo.com/");
        sendText(userNameTextField, username);
        sendText(passwordTextFiled, password);
        clickElement(loginButton);
    }

}
