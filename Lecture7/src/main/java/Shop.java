import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Shop {
    public static String addRandomTractorToCart(String shopUrl, WebDriver driver) throws InterruptedException {
        driver.get(shopUrl);
        Thread.sleep(5000);
        driver.findElement(By.xpath("//a[@href='https://catalog.onliner.by/']")).click();
        driver.findElement(By.xpath("//li[@data-id='6']")).click();
        driver.findElement(By.xpath(
                "//div[@data-id='6']/div/div/div[contains(.,'мототехника')]/div[contains(.,'мототехника')]")).click();
        driver.findElements(By.xpath("//a[@href='https://catalog.onliner.by/minitractor']")).get(1).click();
        List<WebElement> list = driver.findElements(By.xpath(
                "//div[@class='schema-product__group']//div[@class='schema-product__title']/a"));
        int i = Helper.getRandom(list.size());
        String selectedTractor = list.get(i).findElement(By.xpath("./span")).getText();
        driver.findElements(By.xpath("//a[@class='schema-product__button button button_orange']")).get(i).click();
        driver.findElement(By.xpath("//span[contains(.,'По цене')]/..")).click();
        Thread.sleep(2000);
        driver.findElements(By.xpath("//td/a[@data-href='https://cart.onliner.by']")).get(0).click();
        return selectedTractor;
    }

    public static boolean isInCart(String shopCartUrl, WebDriver driver, String product) throws InterruptedException {
        boolean exist = false;
        driver.get(shopCartUrl);
        Thread.sleep(2000);
        List<WebElement> listCartProducts = driver.findElements(By.xpath(
                "//a[@class='cart-product-title__link cart-product-title__link_name']/span"));
        for (WebElement webElement : listCartProducts) {
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