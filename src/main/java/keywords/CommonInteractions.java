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

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
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
    protected Robot rb;
    {
        try {
            rb = new Robot();
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }
    }

    //    Constructor
    public CommonInteractions(WebDriver driver) {
        this.driver = driver;
        this.js = (JavascriptExecutor) driver;
    }

    //    Custom methods following Keyword Driven framework

    /**
     * This method will click on a particular element
     * @param locator Mention the locator where you want to click
     */
    public void clickElement(By locator) {
        driver.findElement(locator).click();
    }

    public void maximizeWindow() {
        driver.manage().window().maximize();
    }

    /**
     * This method will type the text
     * @param locator Mention the locator where you want to type
     * @param text Enter the text that you want to type
     */
    public void sendText(By locator, String text) {
        driver.findElement(locator).sendKeys(text);
    }

    /**
     * This method will launch the URL
     * @param url Enter the desired URL that you want to visit
     */
    public void visitURL(String url) {
        driver.get(url);
    }

    /**
     * This method will fetch the text from a specific locator
     * @param locator Mention the locator from where you want to fetch the text
     * @return
     */
    public String retrieveTextData(By locator) {
        return driver.findElement(locator).getText();
    }

    /**
     * This method will pause the execution for 3 seconds
     */
    public void timeout3Seconds() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * This method is used to scroll down on the screen by 300 pixels
     */
    public void scrollDown() {
        js.executeScript("window.scrollBy(0,300)");
    }

    /**
     * This method is used to select a value from the dropdown
     * @param locator Mention the locator of the dropdown where you want to select
     * @param value Enter the value that should be selected in the dropdown
     */
    public void selectDropdownByVisibleText(By locator, String value) {
        Select dropdown = new Select(driver.findElement(locator));
        dropdown.selectByVisibleText(value);
    }

    /**
     * This method is used to select a value from checkbox
     * @param locator Mention the locator of the dropdown where you want to select
     * @param value Enter the value that should be selected in the checkbox
     */
    public void selectCheckbox(By locator, boolean value) {
        WebElement checkbox = driver.findElement(locator);
        if (checkbox.isSelected() != value) {
            checkbox.click();
        }
    }

    /**
     * This method is used to upload file
     * @param locator Mention the locator of the file upload
     * @param filePath Mention the file path that should be uploaded
     */
    public void uploadFile(By locator, String filePath) {
        WebElement uploadFileLocator = driver.findElement(locator);
        uploadFileLocator.click();
        StringSelection uploadDocument = new StringSelection("C:\\Users\\danis\\OneDrive\\Desktop\\Documents\\" + filePath);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(uploadDocument, null);
        rb.keyPress(KeyEvent.VK_CONTROL);
        rb.keyPress(KeyEvent.VK_V);
        rb.keyPress(KeyEvent.VK_ENTER);
        rb.keyRelease(KeyEvent.VK_ENTER);
    }

    /**
     * This method is used to switch to the child window
     */
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

    /**
     * This method is used to wait for the element to be visible
     * @param locator
     */
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