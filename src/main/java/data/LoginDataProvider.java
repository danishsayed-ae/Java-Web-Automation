package data;

import org.testng.annotations.DataProvider;

public class LoginDataProvider {

    @DataProvider(name = "loginData")
    public Object[][] loginData() {
        return new Object[][] {
                { "t.p1@yopmail.com", "Test@1234" },   // Positive test case
                { "ds@yopmail.com", "Test@1234" },    // Negative test case - incorrect username
                { "t.p1@yopmail.com", "Test@1" }      // Negative test case - incorrect password
        };
    }
}
