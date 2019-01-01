package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends AbstractPage {
    private final String BASE_URL = "https://onliner.by";

    @FindBy(xpath = "//a[@href='https://catalog.onliner.by/']")
    private WebElement catalogLink;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public CatalogPage openCatalogPage() {
        catalogLink.click();
        return new CatalogPage(driver);
    }
}