import constant.Browser;
import factory.WebdriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AddRandomTractorToCartTest {
    private final Browser browser = Browser.CHROME;
    private WebDriver driver;

    @BeforeClass
    private void setDriver() {
        driver = WebdriverFactory.createWebdriver(browser);
    }

    @Test
    private void addRandomTractorToCartTest() throws InterruptedException {
        Shop shop = new Shop(driver);
        String tractorInCart = shop.addRandomTractorToCart();
        Assert.assertTrue(shop.isInCart(tractorInCart));
    }
}