package tests;

import data.RecreationalSignUpDataProvider;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pages.DSNARecreationalSignUpPage;

public class DSNARecreationalSignUpTest extends BaseTest {

    @Test(dataProvider = "recreationalSignUpData", dataProviderClass = RecreationalSignUpDataProvider.class)
    public void testPositiveFlow(String firstName, String lastName, String email, String mobileNo, String password, String cpassword) {
        DSNARecreationalSignUpPage dsnaRecreationalSignUpPage = new DSNARecreationalSignUpPage(driver);
        dsnaRecreationalSignUpPage.performUserSignUp(firstName, lastName, email, mobileNo, password, cpassword);
    }
}
