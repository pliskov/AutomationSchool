import constant.Browser;
import factory.WebdriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class AddRandomTractorToCartTest {
    private final Browser browser = Browser.CHROME;
    private WebDriver driver;

    @BeforeClass
    private void setDriver() {
        driver = WebdriverFactory.createWebdriver(browser);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    private void addRandomTractorToCartTest() {
        Shop shop = new Shop(driver);
        String tractorInCart = shop.addRandomTractorToCart();
        Assert.assertTrue(shop.isInCart(tractorInCart));
    }
}