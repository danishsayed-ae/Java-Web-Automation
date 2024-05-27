package data;

import org.testng.annotations.DataProvider;

public class LoginDataProvider {

    @DataProvider(name = "loginData")
    public Object[][] loginData() {
        return new Object[][] {
                { "t.p1@yopmail.com", "Test@1234", true },   // Positive test case
                { "ds@yopmail.com", "Test@1234", false },    // Negative test case - incorrect username
                { "t.p1@yopmail.com", "Test@1", false }      // Negative test case - incorrect password
        };
    }
}
