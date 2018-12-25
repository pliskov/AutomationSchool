import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

public class Helper {
    public static String addRandomTractorToCart(String shopUrl, WebDriver driver) throws InterruptedException {
        driver.get(shopUrl);
        driver.findElement(By.xpath("//a[@href='https://catalog.onliner.by/']")).click();
        driver.findElement(By.xpath("//li[@data-id='6']")).click();
        driver.findElement(By.xpath(
                "//div[@data-id='6']/div/div/div[contains(.,'мототехника')]/div[contains(.,'мототехника')]")).click();
        driver.findElements(By.xpath("//a[@href='https://catalog.onliner.by/minitractor']")).get(1).click();
        List<WebElement> list = driver.findElements(By.xpath(
                "//div[@class='schema-product__group']//div[@class='schema-product__title']/a"));
        int i = getRandom(list.size());
        String selectedTractor = list.get(i).findElement(By.xpath("./span")).getText();
        driver.findElements(By.xpath("//a[@class='schema-product__button button button_orange']")).get(i).click();
        driver.findElement(By.xpath("//span[contains(.,'По цене')]/..")).click();
        Thread.sleep(2000);
        driver.findElements(By.xpath("//td/a[@data-href='https://cart.onliner.by']")).get(0).click();
        return selectedTractor;
    }

    public static Boolean isInCart(String shopCartUrl, WebDriver driver, String product) throws InterruptedException {
        driver.get(shopCartUrl);
        Thread.sleep(2000);
        if (product.equals(driver.findElement(By.xpath(
                "//a[@class='cart-product-title__link cart-product-title__link_name']/span")).getText())) {
            System.out.println("The product is in the cart");
            return true;
        } else {
            System.out.println("There isn't product in the cart");
            return false;
        }
    }

    private static int getRandom(int range) {
        Random random = new Random();
        return random.nextInt(range);
    }
}