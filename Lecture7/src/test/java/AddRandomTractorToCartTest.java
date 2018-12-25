import constant.Browser;
import factory.WebdriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddRandomTractorToCartTest {
    private final String shopUrl = "https://onliner.by";
    private final String shopCartUrl = "https://cart.onliner.by";
    private final Browser browser = Browser.FIREFOX;

    @Test
    private void addRandomTractorToCartTest() throws InterruptedException {
        WebDriver driver = WebdriverFactory.createWebdriver(browser);
        Assert.assertTrue(Helper.isInCart(shopCartUrl, driver, Helper.addRandomTractorToCart(shopUrl, driver)));
    }
}