package PageObjects;

import GenericKeywords.WebElementsInteractions;
import org.openqa.selenium.By;

public class ProductPageObject extends WebElementsInteractions {
    private final By productPageTitle = By.xpath("//span[@data-test='title']");

    public String getTitleOfPage(By locator)
    {
        return retrieveTextData(productPageTitle);
    }
}
