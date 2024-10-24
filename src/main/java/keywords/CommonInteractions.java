package keywords;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class CommonInteractions {
    protected WebDriver driver;
    protected JavascriptExecutor js;

    /*
    protected Robot rb;

    {
        try {
            rb = new Robot();
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }
    }
*/

    //    Constructor
    public CommonInteractions(WebDriver driver) {
        this.driver = driver;
        this.js = (JavascriptExecutor) driver;
    }

    //    Custom methods using Keyword Driven
    public void clickElement(By locator) {
        driver.findElement(locator).click();
    }

    public void maximizeWindow() {
        driver.manage().window().maximize();
    }

    public void sendText(By locator, String text) {
        driver.findElement(locator).sendKeys(text);
    }

    public void visitURL(String url) {
        driver.get(url);
    }

    public String retrieveTextData(By locator) {
        return driver.findElement(locator).getText();
    }

    public void timeout3Seconds() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void scrollDown() {
        js.executeScript("window.scrollBy(0,300)");
    }

    public void selectDropdownByVisibleText(By locator, String value) {
        Select dropdown = new Select(driver.findElement(locator));
        dropdown.selectByVisibleText(value);
    }

    public void selectCheckbox(By locator, boolean value) {
        WebElement checkbox = driver.findElement(locator);
        if (checkbox.isSelected() != value) {
            checkbox.click();
        }
    }
    
/*    public void uploadFile(By locator, String filePath) {
        WebElement uploadFileLocator = driver.findElement(locator);
        uploadFileLocator.click();
        StringSelection uploadDocument = new StringSelection("C:\\Users\\danis\\OneDrive\\Desktop\\Documents\\" + filePath);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(uploadDocument, null);
        rb.keyPress(KeyEvent.VK_CONTROL);
        rb.keyPress(KeyEvent.VK_V);
        rb.keyPress(KeyEvent.VK_ENTER);
        rb.keyRelease(KeyEvent.VK_ENTER);
    }*/

    public void switchToChildWindow() {
        // Get all the windows
        Set<String> windows = driver.getWindowHandles();

        // Iterator to iterate through all the windows
        Iterator<String> iterator = windows.iterator();

        // By default, iteration is at 0th index and when we do next then it moves to the 1st index.
        String parentID = iterator.next(); // Storing 1st window in a variable
        String childID = iterator.next();  // Storing 2nd window in a variable

        // Switch to the child window
        driver.switchTo().window(childID);
    }

    public void waitForElementToBeVisible(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // 10 seconds timeout
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        // Perform actions on the element
    }

    public void waitForElementToBeClickable(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // 10 seconds timeout
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        element.click();
    }

    public List<HashMap<Object, Object>> getJSONData(String filePath) throws IOException {
        // Reading JSON to String
        String JSONContent = FileUtils.readFileToString(new File(filePath), StandardCharsets.UTF_8);

        // String to Hashmap
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(JSONContent, new TypeReference<List<HashMap<Object, Object>>>() {
        });
    }

}