package pageObjects;

import genericKeywords.WebElementsInteractions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.awt.*;

public class ProductPageObject extends WebElementsInteractions {
    private final By productPageTitle = By.xpath("//span[@data-test='title']");
    private final By getFirstProductText = By.xpath("//a[@id='item_4_title_link']/div");


    public ProductPageObject(WebDriver driver)
    {
        this.driver = driver;
    }

    public String getTitleOfPage()
    {
        return retrieveTextData(productPageTitle);
    }

    public String getProductName()
    {
        return retrieveTextData(getFirstProductText);
    }
}
