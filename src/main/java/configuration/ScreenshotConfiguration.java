package configuration;

import org.apache.commons.io.FileUtils;
import org.apache.hc.client5.http.utils.Base64;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.io.File;
import java.io.IOException;

public class ScreenshotConfiguration
{
    public static String getScreenshot(String imageName, WebDriver driver) throws IOException
    {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File f = ts.getScreenshotAs(OutputType.FILE);
        String filePath = "./Screenshots/"+ imageName;
        FileUtils.copyFile(f, new File(filePath));
        return filePath;
    }

    public static String convertImg_Base64(String screenshotPath) throws IOException {
        byte[] file = FileUtils.readFileToByteArray(new File(screenshotPath));
        String base64Img = Base64.encodeBase64String(file);
        return base64Img;
    }
}
