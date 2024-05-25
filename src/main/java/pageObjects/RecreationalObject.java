package pageObjects;

import genericKeywords.WebElementsInteractions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.awt.*;

public class RecreationalObject extends WebElementsInteractions {
    private final String url = "https://uaelive.astrautm.com/up/pilot-register";
    private final By firstName = By.id("firstName");
    private final By lastName = By.id("lastName");
    private final By arabicFullName = By.id("arabicFullName");
    private final By arabicFamilyName = By.id("arabicFamilyName");
    private final By arabicAlias = By.id("arabicAlias");
    private final By dateOfBirth = By.name("dateOfBirth");
    private final By placeOfBirth = By.id("placeOfBirth");
    private final By placeOfBirthValue = By.xpath("//*[text()='Algeria']");
    private final By gender = By.id("gender");
    private final By genderValue = By.xpath("//*[text()='Male']");
    private final By nationality = By.id("nationality");
    private final By nationalityValue = By.xpath("//*[text()='Algeria']");
    private final By passportNumber = By.id("passportNo");
    private final By passportIssuePlace = By.id("passportIssuePlace");
    private final By passportIssuePlaceValue = By.xpath("//*[text()='Algeria']");
    private final By passportIssueDate = By.name("passportIssueDate");
    private final By passportExpiryDate = By.name("passportExpiryDate");
    private final By emiratesIDNo = By.id("emiratesIDNo");
    private final By emiratesIdExpiryDate = By.name("emiratesIdExpiryDate");
    private final By accountInformation = By.xpath("//h3[normalize-space()='Account Information']");
    private final By emailId = By.id("emailId");
    private final By mobileNumber = By.name("mobileNo");
    private final By phoneNumber = By.name("phoneNumber");
    private final By password = By.id("password");
    private final By confirmPassword = By.id("cpassword");
    private final By stateCode = By.id("stateCode");
    private final By stateCodeValue = By.xpath("//*[text()='Dubai']");
    private final By cityCode = By.id("cityCode");
    private final By cityCodeValue = By.xpath("//*[text()='HATTA ']");
    private final By passport = By.xpath("//label[@for='passportFrontSide']");
    private final By visaCopy = By.xpath("//label[@for='visaCopy']");
    private final By applicantPhoto = By.xpath("//label[@for='applicantPhotograph']");
    private final By emiratesID = By.xpath("//label[@for='emiratesIDFront']");
    private final By pilotTrainingCertificate = By.xpath("//label[@for='pilotTrainingCertificate']");
    private final By termsAndConditions = By.id("checkbox");

    public RecreationalObject(WebDriver driver) throws AWTException{
        this.driver = driver;
    }

    public void fillApplicantInformation(String firstNameValue, String lastNameValue, String arabicFullNameValue, String arabicFamilyNameValue, String arabicAliasValue) {
        visitURL(url);
        sendText(firstName, firstNameValue);
        sendText(lastName, lastNameValue);
        sendText(arabicFullName, arabicFullNameValue);
        sendText(arabicFamilyName, arabicFamilyNameValue);
        sendText(arabicAlias, arabicAliasValue);
        clickElement(dateOfBirth);
        scrollDown();
        clickElement(placeOfBirth);
        clickElement(placeOfBirthValue);
        clickElement(gender);
        clickElement(genderValue);
        clickElement(nationality);
        clickElement(nationalityValue);
    }

    public void fillIdentificationInformation(String passportNumberValue, String emiratesIDNoValue) {
        sendText(passportNumber, passportNumberValue);
        clickElement(passportIssuePlace);
        clickElement(passportIssuePlaceValue);
        clickElement(passportIssueDate);
        clickElement(passportExpiryDate);
        clickElement(emiratesIDNo);
        sendText(emiratesIDNo, emiratesIDNoValue);
        clickElement(emiratesIdExpiryDate);
    }

    public void fillAccountInformation(String mobileNumberValue, String phoneNumberValue, String passwordValue) {
        clickElement(accountInformation);
        scrollDown();
        clickElement(emailId);
        sendText(mobileNumber, mobileNumberValue);
        sendText(phoneNumber, phoneNumberValue);
        sendText(password, passwordValue);
        sendText(confirmPassword, passwordValue);
        scrollDown();
    }

    public void fillDeclarationOfInformation() {
        clickElement(stateCode);
        clickElement(stateCodeValue);
        clickElement(cityCode);
        clickElement(cityCodeValue);
        scrollDown();
    }

    public void uploadAttachments(String passportPath, String visaCopyPath, String applicantPhotoPath, String emiratesIDPath) {
        uploadFile(passport, passportPath);
        uploadFile(visaCopy, visaCopyPath);
        uploadFile(applicantPhoto, applicantPhotoPath);
        uploadFile(emiratesID, emiratesIDPath);
    }

    public void checkTermsAndConditions() {
        clickElement(termsAndConditions);
    }
    
}
