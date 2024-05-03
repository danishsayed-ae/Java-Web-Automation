package PageObjects;

import GenericKeywords.WebElementsInteractions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPageObject extends WebElementsInteractions {
    private final By productPageTitle = By.xpath("//span[@data-test='title']");

    public ProductPageObject(WebDriver driver)
    {
        this.driver = driver;
    }

    public String getTitleOfPage()
    {
        return retrieveTextData(productPageTitle);
    }
}
