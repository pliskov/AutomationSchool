package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CatalogTractorsPage extends BasePage {

    @FindBy(xpath = "//a[@class='schema-product__button button button_orange']")
    private List<WebElement> listOffersButtons;

    public CatalogTractorsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public TractorPricesPage openRandomTractorPricesPage() {
        listOffersButtons.get(Helper.getRandom(listOffersButtons.size())).click();
        return new TractorPricesPage(driver);
    }
}