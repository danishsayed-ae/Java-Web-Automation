package GenericKeywords;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WebElementsInteractions {
    protected WebDriver driver;

//These are custom created function that helps us to build keyword driven strategy
    public void clickElement (By locator)
    {
        driver.findElement(locator).click();
    }

    public void sendText (By locator, String text)
    {
        driver.findElement(locator).sendKeys(text);
    }

    public void goToApplication (String url)
    {
        driver.get(url);
    }

    public String retrieveTextData (By locator)
    {
        return driver.findElement(locator).getText();
    }
}
