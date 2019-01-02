package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CartPage extends AbstractPage {
    @FindBy(xpath = "//a[@class='cart-product-title__link cart-product-title__link_name']/span")
    private List<WebElement> listCartProducts;

    public CartPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public List<WebElement> getListCartProducts() {
        return listCartProducts;
    }
}