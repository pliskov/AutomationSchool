package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CatalogPage extends AbstractPage {

    @FindBy(xpath = "//li[@data-id='6']")
    private WebElement autoMotoTab;

    @FindBy(xpath = "//div[@data-id='6']/div/div/div[contains(.,'мототехника')]/div[contains(.,'мототехника')]")
    private WebElement autoMotoSubTab;

    @FindBy(xpath = "//a[@href='https://catalog.onliner.by/minitractor']")
    private List<WebElement> catalogTractorLinks;

    public CatalogPage(WebDriver driver) {
        super(driver);
    }

    public CatalogTractorsPage openCatalogTractorsPage() {
        autoMotoTab.click();
        autoMotoSubTab.click();
        catalogTractorLinks.get(1).click();
        return new CatalogTractorsPage(driver);
    }
}