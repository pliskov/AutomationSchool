package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {
    private final String homePageUrl = "https://onliner.by";

    @FindBy(xpath = "//a[@href='https://catalog.onliner.by/']")
    private WebElement catalogLink;

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public void open() {
        driver.get(homePageUrl);
    }

    public CatalogPage openCatalogPage() {
        catalogLink.click();
        return new CatalogPage(driver);
    }
}