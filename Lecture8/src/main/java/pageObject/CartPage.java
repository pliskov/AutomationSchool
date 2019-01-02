package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CartPage extends AbstractPage {
    @FindBy(xpath = "//a[@class='cart-product-title__link cart-product-title__link_name']/span")
    private List<WebElement> listCartProducts;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public List<WebElement> getListCartProducts() {
        return listCartProducts;
    }
}