package genericKeywords;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class WebElementsInteractions {
    protected WebDriver driver;
    JavascriptExecutor js = (JavascriptExecutor) driver;
    Robot rb;

    {
        try {
            rb = new Robot();
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }
    }

    public WebElementsInteractions() {
    }

    //These are custom created function that helps us to build keyword driven strategy
    public void clickElement(By locator) {
        driver.findElement(locator).click();
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

    public void threadSleep() throws InterruptedException {
        Thread.sleep(1000);
    }

    public void scrollDown() {
        js.executeScript("window.scrollBy(0,300)");
    }

    public void uploadFile(By locator, String filePath) {
        WebElement uploadFileLocator = driver.findElement(locator);
        uploadFileLocator.click();
        StringSelection uploadDocument = new StringSelection("C:\\Users\\danis\\OneDrive\\Desktop\\Documents\\"+filePath);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(uploadDocument, null);
        rb.keyPress(KeyEvent.VK_CONTROL);
        rb.keyPress(KeyEvent.VK_V);
        rb.keyPress(KeyEvent.VK_ENTER);
        rb.keyRelease(KeyEvent.VK_ENTER);
    }
}
