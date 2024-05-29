package pages;

import genericKeywords.WebElementsInteractions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DSNARecreationalSignUpPage extends WebElementsInteractions {
    //    Locators
    private final By changeLanguageToEnglish = By.xpath("//button[contains(text(),'English')]");
    private final By firstNameTextField = By.id("firstName");
    private final By lastNameTextFiled = By.id("lastName");
    private final By emailTextField = By.id("emailId");
    private final By mobileNumberTextField = By.id("mobileNo");
    private final By passwordTextField = By.id("password");
    private final By confirmPasswordTextField = By.id("cpassword");
    private final By termsAndConditions = By.id("checkbox");
    private final By loginButton = By.xpath("//button[@type='submit']");

//    Constructor
    public DSNARecreationalSignUpPage(WebDriver driver) {
        this.driver = driver;
    }

//    Page Action
    public void performUserSignUp(String firstName, String lastName, String email, String mobileNo, String password, String confirmPassword) {
        visitURL("https://stagingdsna.astrautm.com/pilot-register");
        clickElement(changeLanguageToEnglish);
        sendText(firstNameTextField, firstName);
        sendText(lastNameTextFiled, lastName);
        sendText(emailTextField, email);
        sendText(mobileNumberTextField, mobileNo);
        sendText(passwordTextField, password);
        sendText(confirmPasswordTextField, confirmPassword);
        clickElement(termsAndConditions);
        clickElement(loginButton);
    }
}
