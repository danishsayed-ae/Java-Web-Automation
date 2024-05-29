package data;

import org.testng.annotations.DataProvider;

public class RecreationalSignUpDataProvider {
    @DataProvider(name = "recreationalSignUpData")
    public Object[][] recreationalSignUpData() {
        return new Object[][]{
                {"Danish", "Sayed", "danish.s@yopmail.com", "567889012", "Test@1234", "Test@1234"}
        };
    }
}
