package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CatalogTractorsPage extends AbstractPage {

    @FindBy(xpath = "//div[@class='schema-product__group']//div[@class='schema-product__title']/a/span")
    private List<WebElement> listTractorsTitles;

    @FindBy(xpath = "//a[@class='schema-product__button button button_orange']")
    private List<WebElement> listOffersButtons;

    public CatalogTractorsPage(WebDriver driver) {
        super(driver);
    }

    public TractorPricesPage openRandomTractorPricesPage() {
        int i = Helper.getRandom(listTractorsTitles.size());
        String selectedTractor = listTractorsTitles.get(i).getText();
        listOffersButtons.get(i).click();
        return new TractorPricesPage();
    }
}