package tests;

import org.testng.annotations.Test;
import pages.UAELiveRecreationalSignUpPage;

import java.time.Duration;

public class RecreationalSignUpTest extends BaseTest{
    UAELiveRecreationalSignUpPage UAELiveRecreationalSignUpPage;

    @Test
    public void recreationalTest() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        UAELiveRecreationalSignUpPage = new UAELiveRecreationalSignUpPage(driver);
        UAELiveRecreationalSignUpPage.fillApplicantInformation("Danish", "Sayed","سيد دانيش","سيد دانيش", "سيد دانيش");
        UAELiveRecreationalSignUpPage.fillIdentificationInformation("N12345678", "199612345670");
        UAELiveRecreationalSignUpPage.fillAccountInformation("danishsayed1@yopmail.com", "567998098", "567998098", "Test@1234");
        UAELiveRecreationalSignUpPage.fillDeclarationOfInformation();
        UAELiveRecreationalSignUpPage.uploadAttachments("Operator Passport.pdf", "Visa Copy.pdf", "Drone Operator Photograph.jpg", "Operator Emirates ID.pdf");
        UAELiveRecreationalSignUpPage.checkTermsAndConditions();
    }
}
