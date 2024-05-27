package pages;

import genericKeywords.WebElementsInteractions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends WebElementsInteractions {
    private final By userNameTextField = By.id("email");
    private final By passwordTextFiled = By.id("password");
    private final By loginButton = By.id("btnLgnSubmit");

    public LoginPage(WebDriver driver)
    {
        this.driver = driver;
    }

    public void adminLogin(String username, String password) throws InterruptedException {
        visitURL("https://uaelive.astrautm.com/");
        Thread.sleep(3000);
        sendText(userNameTextField, username);
        Thread.sleep(3000);
        sendText(passwordTextFiled, password);
        Thread.sleep(3000);
        clickElement(loginButton);

    }
}
