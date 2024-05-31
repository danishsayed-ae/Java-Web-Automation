package data;

//import genericKeywords.WebElementsInteractions;
import org.testng.annotations.DataProvider;

import java.util.HashMap;

public class LoginDataProvider {

    @DataProvider(name = "loginData")
    public Object[][] loginData() {
        return new Object[][] {
                { "t.p1@yopmail.com", "Test@1234" },   // Positive test case
                { "ds@yopmail.com", "Test@1234" },    // Negative test case - incorrect username
                { "t.p1@yopmail.com", "Test@1" }      // Negative test case - incorrect password
        };
    }
//
//    @DataProvider(name = "loginDataFromJson")
//    public Object[][] loginDataFromJson() {
//        List<LoginData> loginDataList = WebElementsInteractions.JsonUtils.readLoginData("path/to/your/json/file.json");
//        Object[][] data = new Object[loginDataList.size()][2];
//        for (int i = 0; i < loginDataList.size(); i++) {
//            data[i][0] = loginDataList.get(i).getUsername();
//            data[i][1] = loginDataList.get(i).getPassword();
//        }
//        return data;
//    }
}
