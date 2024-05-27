package tests;

import org.testng.annotations.Test;
import pages.RecreationalSignUpPage;

import java.time.Duration;

public class RecreationalTest extends BaseTest{
    RecreationalSignUpPage recreationalSignUpPage;

    @Test
    public void recreationalTest() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        recreationalSignUpPage = new RecreationalSignUpPage(driver, js);
        recreationalSignUpPage.fillApplicantInformation("Danish", "Sayed","سيد دانيش","سيد دانيش", "سيد دانيش");
        recreationalSignUpPage.fillIdentificationInformation("N12345678", "199612345670");
        recreationalSignUpPage.fillAccountInformation("danishsayed1@yopmail.com", "567998098", "567998098", "Test@1234");
        recreationalSignUpPage.fillDeclarationOfInformation();
        recreationalSignUpPage.uploadAttachments("Operator Passport.pdf", "Visa Copy.pdf", "Drone Operator Photograph.jpg", "Operator Emirates ID.pdf");
        recreationalSignUpPage.checkTermsAndConditions();
    }
}
