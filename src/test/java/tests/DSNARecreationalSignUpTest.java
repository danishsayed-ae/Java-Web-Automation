package tests;

import dataProvider.RecreationalSignUpDataProvider;
import org.testng.annotations.Test;
import pages.DSNARecreationalSignUpPage;

public class DSNARecreationalSignUpTest extends BaseTest {

    @Test(dataProvider = "recreationalSignUpData", dataProviderClass = RecreationalSignUpDataProvider.class)
    public void testUserSignUp(String firstName, String lastName, String email, String mobileNo, String password, String confirmPassword) {
        DSNARecreationalSignUpPage dsnaRecreationalSignUpPage = new DSNARecreationalSignUpPage(driver);
        dsnaRecreationalSignUpPage.performUserSignUp(firstName, lastName, email, mobileNo, password, confirmPassword);

    }
}
