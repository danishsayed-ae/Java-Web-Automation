package tests;

import org.testng.annotations.Test;
import pages.DSNARecreationalSignUpPage;

public class DSNARecreationalSignUpTest extends BaseTest{
    DSNARecreationalSignUpPage dsnaRecreationalSignUpPage = new DSNARecreationalSignUpPage(driver);

    @Test (dataProvider = )
    public void testPositiveFlow() {
        dsnaRecreationalSignUpPage.userSignUp();
    }
}
