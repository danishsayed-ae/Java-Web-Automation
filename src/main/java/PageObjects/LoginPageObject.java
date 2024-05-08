package PageObjects;

import GenericKeywords.WebElementsInteractions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPageObject extends WebElementsInteractions
{
//    We are declaring a private variable so that it cannot be accessed outside the LoginPageObject class
//    We are declaring a final variable so that its value cannot be changed once assigned
    private final By userNameTextField = By.id("user-name");
    private final By passwordTextFiled = By.id("password");
    private final By loginButton = By.id("login-button");

//    We have created a constructor and the parameter driver is given life from the WebElementsInteractions class
    public LoginPageObject(WebDriver driver)
    {
        this.driver = driver;
    }

//    We have created this method that expects two String parameters username and password
    public void userLogin(String username, String password) throws InterruptedException {
        goToApplication("https://www.saucedemo.com/");
        sendText(userNameTextField, username);
        Thread.sleep(3000);
        sendText(passwordTextFiled, password);
        Thread.sleep(3000);
        clickElement(loginButton);
    }

}
