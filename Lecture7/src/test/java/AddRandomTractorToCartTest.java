import constant.Browser;
import factory.WebdriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddRandomTractorToCartTest {
    private final String shopUrl = "https://onliner.by";
    private final String shopCartUrl = "https://cart.onliner.by";
    private final Browser browser = Browser.CHROME;

    @Test
    private void addRandomTractorToCartTest() throws InterruptedException {
        WebDriver driver = WebdriverFactory.createWebdriver(browser);
        String tractorInCart = Shop.addRandomTractorToCart(shopUrl, driver);
        Assert.assertTrue(Shop.isInCart(shopCartUrl, driver, tractorInCart));
    }
}