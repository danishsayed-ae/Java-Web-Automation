package tests;

import data.RecreationalSignUpDataProvider;
import org.testng.annotations.Test;
import pages.DSNARecreationalSignUpPage;

public class DSNARecreationalSignUpTest extends BaseTest{
    DSNARecreationalSignUpPage dsnaRecreationalSignUpPage = new DSNARecreationalSignUpPage(driver);

    @Test (dataProvider = "recreationalSignUpData", dataProviderClass = RecreationalSignUpDataProvider.class)
    public void testPositiveFlow() {
        dsnaRecreationalSignUpPage.userSignUp(firstName, lastName, email, mobileNo, password, cpassword);
    }
}
