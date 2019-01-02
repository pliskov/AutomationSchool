import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import pageObject.*;

public class Shop {
    public static String addRandomTractorToCart(String homepageUrl, WebDriver driver) throws InterruptedException {
        driver.get(homepageUrl);
        Thread.sleep(5000);
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        CatalogPage catalogPage = homePage.openCatalogPage();
        CatalogTractorsPage catalogTractorsPage = catalogPage.openCatalogTractorsPage();
        TractorPricesPage tractorPricesPage = catalogTractorsPage.openRandomTractorPricesPage();
        tractorPricesPage.addTractorToCart();
        return catalogTractorsPage.getSelectedTractor();
    }

    public static boolean isInCart(String shopCartUrl, String product, WebDriver driver) throws InterruptedException {
        boolean exist = false;
        driver.get(shopCartUrl);
        Thread.sleep(2000);
        CartPage cartPage = PageFactory.initElements(driver, CartPage.class);
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