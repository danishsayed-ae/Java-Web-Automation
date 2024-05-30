package genericKeywords;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

public class WebElementsInteractions {
    protected WebDriver driver;
    protected JavascriptExecutor js = (JavascriptExecutor) driver;
    protected Robot rb;

    {
        try {
            rb = new Robot();
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }
    }

    //    Constructor
    public WebElementsInteractions(WebDriver driver) {
        this.driver = driver;
        this.js = (JavascriptExecutor) driver;
    }

    //    Custom methods using Keyword Driven
    public void clickElement(By locator) {
        driver.findElement(locator).click();
    }

    public void clickCheckboxUsingJS(By locator) {
        WebElement checkbox = driver.findElement(locator);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", checkbox);
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

    public void timeout1Second() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void scrollDown() {
        js.executeScript("window.scrollBy(0,300)");
    }

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
}
