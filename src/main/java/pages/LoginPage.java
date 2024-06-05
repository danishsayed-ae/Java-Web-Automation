package pages;

import genericKeywords.WebElementsInteractions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends WebElementsInteractions {
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
//        timeout1Second();
        clickElement(changeLanguageToEnglish);
//        timeout1Second();
        sendText(userNameTextField, username);
//        timeout1Second();
        sendText(passwordTextField, password);
        timeout1Second();
        clickElement(loginButton);
        timeout1Second();
    }
}
