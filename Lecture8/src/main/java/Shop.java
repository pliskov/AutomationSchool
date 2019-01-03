import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageObject.*;

public class Shop {
    private WebDriver driver;

    public Shop(WebDriver driver) {
        this.driver = driver;
    }

    public String addRandomTractorToCart() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        homePage.open();
        CatalogPage catalogPage = homePage.openCatalogPage();
        CatalogTractorsPage catalogTractorsPage = catalogPage.openCatalogTractorsPage();
        TractorPricesPage tractorPricesPage = catalogTractorsPage.openRandomTractorPricesPage();
        tractorPricesPage.addTractorToCart();
        return catalogTractorsPage.getSelectedTractor();
    }

    public boolean isInCart(String product) throws InterruptedException {
        boolean exist = false;
        CartPage cartPage = new CartPage(driver);
        cartPage.openCart();
        for (WebElement webElement : cartPage.getListCartProducts()) {
            if (product.equals(webElement.getText())) {
                System.out.println("The product is in the cart");
                exist = true;
                return exist;
            }
        }
        if (!exist) {
            throw new RuntimeException("There isn't product in the cart");
        }
        return exist;
    }
}