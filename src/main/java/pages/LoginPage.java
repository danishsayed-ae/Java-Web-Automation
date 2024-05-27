package pages;

import genericKeywords.WebElementsInteractions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends WebElementsInteractions {
//    Locators
    private final By changeLanguage = By.xpath("//button[contains(text(),'English')]");
    private final By userNameTextField = By.id("username");
    private final By passwordTextFiled = By.id("password");
    private final By loginButton = By.xpath("//button[@type='submit']");

//    Constructor
    public LoginPage(WebDriver driver)
    {
        this.driver = driver;
    }

//    Page Action
    public void userLogin(String username, String password) {
        visitURL("https://stagingdsna.astrautm.com/");
        timeout3Seconds();
        clickElement(changeLanguage);
        timeout3Seconds();
        sendText(userNameTextField, username);
        timeout3Seconds();
        sendText(passwordTextFiled, password);
        timeout3Seconds();
        clickElement(loginButton);
        timeout3Seconds();
    }
}
