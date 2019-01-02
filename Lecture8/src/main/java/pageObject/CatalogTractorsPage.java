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

    private int selectedRandomNumber;
    private String selectedTractor;

    public CatalogTractorsPage(WebDriver driver) {
        super(driver);
    }

    public int getSelectedRandomNumber() {
        return selectedRandomNumber;
    }

    public String getSelectedTractor() {
        return selectedTractor;
    }

    public TractorPricesPage openRandomTractorPricesPage() {
        selectedRandomNumber = Helper.getRandom(listTractorsTitles.size());
        selectedTractor = listTractorsTitles.get(selectedRandomNumber).getText();
        listOffersButtons.get(selectedRandomNumber).click();
        return new TractorPricesPage(driver);
    }
}