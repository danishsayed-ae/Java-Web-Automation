package pages;

import genericKeywords.WebElementsInteractions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SauceDemoProductPage extends WebElementsInteractions {
    private final By productPageTitle = By.xpath("//span[@data-test='title']");
    private final By getFirstProductText = By.xpath("//a[@id='item_4_title_link']/div");


    public SauceDemoProductPage(WebDriver driver)
    {
        super(driver);
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
