package tests;

import data.RecreationalSignUpDataProvider;
import org.testng.annotations.Test;
import pages.DSNARecreationalSignUpPage;

public class DSNARecreationalSignUpTest extends BaseTest{


    @Test (dataProvider = "recreationalSignUpData", dataProviderClass = RecreationalSignUpDataProvider.class)
    public void testPositiveFlow() {
        DSNARecreationalSignUpPage dsnaRecreationalSignUpPage = new DSNARecreationalSignUpPage(driver);
//        dsnaRecreationalSignUpPage.userSignUp(firstName, lastName, email, mobileNo, password, cpassword);
    }
}
