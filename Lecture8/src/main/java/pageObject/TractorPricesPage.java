package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class TractorPricesPage extends BasePage {

    @FindBy(xpath = "//span[contains(.,'По цене')]/..")
    private WebElement sortOffersByPriceLink;

    @FindBy(xpath = "//td/a[@data-href='https://cart.onliner.by']")
    private List<WebElement> listAddToCartLinks;

    @FindBy(xpath = "//img[@class='offers-description__image']")
    private WebElement productName;

    public TractorPricesPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public String getTractorName() {
        return productName.getAttribute("title");
    }

    public void addTractorToCart() {
        if(listAddToCartLinks.size() != 0) {
            sortOffersByPriceLink.click();
            WebDriverWait wait = new WebDriverWait(driver, 5);
            wait.until(ExpectedConditions.visibilityOfAllElements(listAddToCartLinks));
            listAddToCartLinks.get(0).click();
        }
        else {
            throw new RuntimeException("There aren't offers for selected product");
        }
    }
}