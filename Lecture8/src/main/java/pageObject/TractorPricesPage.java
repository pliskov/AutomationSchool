package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class TractorPricesPage extends AbstractPage {

    CatalogTractorsPage catalogTractorsPage = new CatalogTractorsPage(driver);

    @FindBy(xpath = "//span[contains(.,'По цене')]/..")
    private WebElement sortOffersByPriceLink;

    @FindBy(xpath = "//td/a[@data-href='https://cart.onliner.by']")
    private List<WebElement> listAddToCartLinks;

    public TractorPricesPage(WebDriver driver) {
        super(driver);
    }

    public void addTractorToCart() throws InterruptedException {
        sortOffersByPriceLink.click();
        Thread.sleep(2000);
        listAddToCartLinks.get(catalogTractorsPage.getSelectedRandomNumber()).click();
    }
}