package dataProvider;


import keywords.CommonInteractions;
import org.testng.annotations.DataProvider;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class LoginDataProvider {

//    Using the below dataset for test execution
    @DataProvider(name = "loginData")
    public Object[][] loginData() {
        return new Object[][]{
                {"t.p1@yopmail.com", "Test@1234"},   // Positive test case
                {"ds@yopmail.com", "Test@1234"},    // Negative test case - incorrect username
                {"t.p1@yopmail.com", "Test@1"}      // Negative test case - incorrect password
        };
    }

    @DataProvider(name = "loginDataFromJson")
    public Object[][] loginDataFromJson() throws IOException {
//        Initialize with null driver for utility purpose
        CommonInteractions commonInteractions = new CommonInteractions(null);

//        Specify the path from where it should get the test dataset
        List<HashMap<Object, Object>> loginDataList = commonInteractions.getJSONData(System.getProperty("user.dir") + "/src/main/java/testData/loginTestData.json");

        Object[][] data = new Object[loginDataList.size()][2];
        for (int i = 0; i < loginDataList.size(); i++) {
            data[i][0] = loginDataList.get(i).get("username");
            data[i][1] = loginDataList.get(i).get("password");
        }
        return data;
    }
}
