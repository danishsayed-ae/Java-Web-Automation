package pageTests;

import org.testng.annotations.Test;
import pageObjects.RecreationalObject;

public class RecreationalTest extends BaseTest{
    RecreationalObject recreationalObject;

    @Test
    public void recreationalTest(){
        recreationalObject = new RecreationalObject(driver);
        recreationalObject.fillApplicantInformation("Danish", "Sayed","سيد دانيش","سيد دانيش", "سيد دانيش");
        recreationalObject.fillIdentificationInformation("N12345678", "199612345670");
        recreationalObject.fillAccountInformation("danishsayed1@yopmail.com", "567998098", "567998098", "Test@1234");
        recreationalObject.fillDeclarationOfInformation();
        recreationalObject.uploadAttachments("Operator Passport.pdf", "Visa Copy.pdf", "Drone Operator Photograph.jpg", "Operator Emirates ID.pdf");
        recreationalObject.checkTermsAndConditions();
    }
}
