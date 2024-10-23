package pages;

import keywords.CommonInteractions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends CommonInteractions {
    //    Locators
    private final By changeLanguageToEnglish = By.xpath("//button[contains(text(),'English')]");
    private final By userNameTextField = By.id("username");
    private final By passwordTextField = By.id("password");
    private final By loginButton = By.xpath("//button[@type='submit']");

    //    Constructor
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    //    Page Action
    public void performUserLogin(String username, String password) {
        maximizeWindow();
        visitURL("https://stagingdsna.astrautm.com/");
        timeout3Seconds();
        clickElement(changeLanguageToEnglish);
//        timeout1Second();
        sendText(userNameTextField, username);
//        timeout1Second();
        sendText(passwordTextField, password);
        timeout3Seconds();
        clickElement(loginButton);
        timeout3Seconds();
    }
}
